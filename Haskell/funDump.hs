import Data.Char 
import Data.List

--Field Vars
zero10 = [0..10]
atoz = ['a'..'z']
tuplePairs = [("moo", 2), ("owo", 4), ("sue", 10)]

wl = ["China", "East", "Xi Jiping", "The number one", "Cpc", "Rice", "Bao"]
al = ["Red", "Best", "Beautiful", "Independent", "Irreplacable"]
wordCombo nouns adjs = [adj ++ " " ++ noun | adj <- adjs, noun <- nouns, head noun == head adj]

distOrg xy = sqrt ((x - 0)^2 + (y - 0)^2)
     where x = fst xy
           y = snd xy

closeOrg xys = [ xy | xy <- xys, (distOrg xy) < 5]

--numAmount xs x = length $ filter (==x) xs 
--uniquePairs xs = [(a, 0) | a <- nub xs]

hash (c:x) = ( ord c * (31 ^ ( length x ) ) ) + hash x
hash [] = 0

hashpair xs = [(x, hash x) | x <- xs]

aTrap :: (Fractional a) => a -> a -> a -> a
aTrap a b h = ((a + b) / 2) * h

tail' :: [a] -> a
tail' xs = xs !! (length xs - 1)

pythag :: (Integral a) => a -> a -> a -> Bool
pythag a b c = a^2 + b^2 == c^2

isAscendingOrder :: (Ord a) => [a] -> Bool
isAscendingOrder [] = True
isAscendingOrder [x] = True
isAscendingOrder (x:xs) = isAscendingOrder xs && [x] < xs 

subt :: [Char] -> [Char] -> Integer
subt c1 c2 = (read c1 :: Integer) - (read c2 :: Integer)

--badAvg :: (Fractional a) => [a] -> Float
--badAvg xs = (sum xs) / (length xs)

xsToNums :: [Char] -> [Double]
xsToNums xs = [read xs :: Double | x <- xs]

above8 :: [(String, Int)] -> [(String, Int)]
above8 xs = filter (\y -> snd y > 8) xs

triBtwn' :: (Ord a, Integral a) => a -> a -> [(a,a,a)] 
triBtwn' = \x y -> filter (triangle) [(a,b,c) | a <- [x..y], b <- [x..y], c <- [x..y]]
                   where triangle (a,b,c) = a + b > c

canVote = do
    putStrLn "What is your age?"
    age <- getLine
    if (read age :: Int) > 17 then putStrLn "You can vote" else putStrLn "You can't vote"

sequencex = do
        putStrLn "What is the start"
        strt <- getLine
        putStrLn "What is the stop"
        stop <- getLine
        putStrLn "What is the delta"
        delt <- getLine
        let s1 = read strt :: Int
        let s2 = read stop :: Int
        let d  = read delt :: Int
        print (seqx s1 s2 d)

seqx str stp del 
    | del < 0 && stp > 0 = error "Sequence will not work."        
    | del > 0 && stp < 0 = error "Sequence will not work."
    | otherwise = [ str, str + del.. stp]