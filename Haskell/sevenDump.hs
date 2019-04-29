import Data.Char

fromOrigin :: (RealFloat a) => [(a, a)] -> [a]
fromOrigin points = [ distance | (x, y) <- points, let distance = sqrt ((x - 0)^2 + (y - 0)^2) ]

closeEnough :: (RealFloat a) => [(a, a)] -> a -> [((a, a), a)]
closeEnough points d = [ ((x,y), distance) | (x, y) <- points, let distance = sqrt ((x - 0)^2 + (y - 0)^2), distance < d]

article :: [Char] -> [Char]
article word = case head word `elem` "aeiou" of True  -> "an " ++ word
                                                False -> "a " ++ word 

haveNum :: Int -> [Char] -> [Char]
haveNum x word = case x > 1 || x < 0 of True -> "You have " ++ show x ++ ' ':word ++ ['s']
                                        False -> "You have a " ++ word 

gpa :: Char -> String
gpa x = case toUpper x of 'A' -> "You earned a 4.0 GPA."
                          'B' -> "You earned a 3.0 GPA."
                          'C' -> "You earned a 2.0 GPA."
                          'D' -> "You earned a 1.0 GPA."
                          'F' -> "You earned a 0.0 GPA."                              

factorial :: Integral a => a -> a
factorial 1 = 1
factorial x = x * factorial (x - 1)            

pow :: Integral a => a -> a -> a
pow x 1 = x
pow x y = x * pow x (y - 1)

fib :: Integral a => a -> a
fib 0 = 0
fib 1 = 1
fib 2 = 1
fib x = fib (x - 2) + fib (x - 1)

reverse' :: [a] -> [a]
reverse' [] = []
reverse' (x:xs) = reverse' xs ++ [x]