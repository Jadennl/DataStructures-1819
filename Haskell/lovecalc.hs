-- Haskell Set 9

-- Today we will make a love calculator... 
-- not only will this find your percent compatability
-- but it will also give you children names.

-- We need to import these modules in order to use some functions:
--import Control.Monad
import Data.Char
import Data.List
import System.IO

-- There will be a live interactive part and the background code.
main = do
-- 1) Find a way to ask the user for their name:
    putStrLn "What is the first person's name?"
    user <- getLine

-- 2) Find a way to ask the user for their crush(?):
    putStrLn "What is the second person's name?"
    crush <- getLine

-- Input can containe spaces.
-- 3) Let the user see the results:
    let loveP = percent $ finalEdge $ occurs $ love user crush
    let total = "Love percentage between " ++ user ++ " and " ++ crush ++ ": " ++ loveP
    putStrLn total

-- 4) Ask if the user wants to play again, if yes, play again:
    putStrLn "Would you like to calculate another love? (Y/N)"
    response <- getChar
    _ <- getLine
    if elem response "Yy"                    
        then main
        else do
-- i) Ask the user if they want to see children names:
            putStrLn "Would you like some recomendations for child names? (Y/N)"
            response <- getChar
            _ <- getLine
            if elem response "Yy"                    
                then do
                    let babies = goodNames $ (child user crush ++ child crush user)
                    writeFile "Babies.txt" (show babies)
                    babyLoop babies
                else return ()

babyLoop :: [String] -> IO ()
babyLoop babyNames = do
    putStrLn $ putOne babyNames
    response <- getChar
    _ <- getLine
    if elem response "YyNn" && (length babyNames > 0) 
      then if elem response "Yy"
        then do
            let result = "Be sure to name your child " ++ (show (head babyNames)) ++ " then!"
            putStrLn result
            putStrLn "The rest of the names are already in a file."
        else do babyLoop (tail babyNames)
      else return ()


-- I hope thats enough IO!

-- In order to calculate, we need to make sure the phrase is together.
-- 5) combine the two names into a single string:
love x y = [toLower z | z <- (x ++ y), z /= ' ']

-- 6) Find out each time a letter occurs and list it out:
occur :: Char -> String -> Int
occur x xs = length $ filter (==x) xs

occurs xs = [ occur x xs | x <- nub xs]

-- ii) For debugging, tuple it with the char:
occurPair :: String -> [(Char, Int)]
occurPair xs = [ (x, occur x xs) | x <- nub xs]

-- In a love calculator, the first and last occurance 
-- are added until 2 numbers are left.

-- 7) given the occurPair result, add up the first and last numbers given.
sumEdges :: [Int] -> [Int]
sumEdges []     = []
sumEdges (x:[]) = [x]
sumEdges (x:xs) = (x + last xs):(sumEdges $ init xs)

-- 8) make sure the program runs more than once.
finalEdge :: [Int] -> [Int]
finalEdge xs
    | length xs == 1 = xs
    | length xs == 2 = if (length (split xs)) > 2 then finalEdge (split xs) else xs
    | otherwise      = finalEdge $ sumEdges xs

-- 9) In the event of a number over 10, split the number so we do not have over 100% 
split :: [Int] -> [Int]
split (x:y:_) 
    | x >= 10 && y >= 10 = [div x 10] ++ [mod x 10] ++ [div y 10] ++ [mod y 10]
    | x >= 10 && y <  10 = [div x 10] ++ [mod x 10] ++ [y]
    | x <  10 && y >= 10 = [x] ++ [div y 10] ++ [mod y 10]
    | otherwise          = [x] ++ [y] 

-- 10) Create the percentage 
percent :: [Int] -> String 
percent (x:[])  = (show x) ++ ['%']
percent (x:y:_) = (show x) ++ (show y) ++ ['%']

-- [Part 3] We need to find poorly made children names.

-- 11) List all possible children names.
child :: String -> String -> [[Char]]
child x y = [(take n1 x) ++ (drop n2 y)  | n1 <- [1..length x - 1], n2 <- [1..length y - 1]]

-- iii) We need good names. Names should be atleast 3 letters.
goodNames :: [String] -> [String]
goodNames xs = sort $ nub $ filter (\x -> length x >= 3 && any (`elem` "AaEeIiOoUuYy") x) xs

-- iv) Display names one at a time unless there are no names left:
putOne :: [[Char]] -> String
putOne [] = "No names left"
putOne (x:_) = "Cute baby name: " ++ x ++ " (Y/N)?"

-- v) Possible format the lists
