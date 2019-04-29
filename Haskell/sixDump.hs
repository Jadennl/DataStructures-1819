--module sixDump (triple1,triple2,triple3,giveName,whatColor,bad8Ball,menu,average,firstThree) where

import Data.Char
import Data.List

triple1 (x,_,_) = x
triple2 (_,y,_) = y
triple3 (_,_,z) = z

giveName :: String -> String
giveName xs
    | xs == "Jaden"   = "First Name"
    | xs == "No"  = "Middle Name"
    | xs == "L" = "Last Name"
    | otherwise       = "Stranger Danger!"

whatColor :: (Integer,Integer,Integer) -> String
whatColor (r,g,b)
    | r == 255 && g == r   && b == r   = "White"
    | r == 0   && g == r   && b == r   = "Black"
    | r == 255 && g == 0   && b == g   = "Red"
    | r == 0   && g == 255 && b == r   = "Green"
    | r == 0   && g == r   && b == 255 = "Blue"
    | r == g   && g == b               = "A shade of Gray"
    | bad r    || bad g    || bad b    = "Not a color"
    | otherwise                        = show (r,g,b)
    where bad a = a > 255 || a < 0

bad8Ball :: Int -> String    
bad8Ball x
    | x == 1 = "It is decidedly so"
    | x == 2 = "My sources say no"
    | x == 3 = "Ask again later"

menu :: Int -> String
menu x 
    | x == 1 = "Deposit"
    | x == 2 = "Withdraw"
    | x == 3 = "Log out"

average :: (Fractional a) => [a] -> a
average []   = error "Empty List"
average nums = (sum nums) / (fromIntegral $ length nums)

firstThree :: [a] -> [a]
firstThree xs
    | len <  3   = xs
    | otherwise  = take 3 xs
    where len    = length xs

tail' :: [a] -> [a]
tail' [] = error "Empty List"
tail' (x:xs) = xs

pow :: (Integral a) => a -> a -> a
pow a 0 = 1 
pow a 1 = a
pow a x = a * pow a (x-1)

grade2 :: Integer -> [Char]
grade2 g
    | g < 0     = "Liar"
    | g <= 60   = "F"
    | g <  70   = "D"
    | g <  80   = "C"
    | g <  90   = "B"
    | g <  100  = "A"
    | otherwise = "Liar"

weird6 :: [Char] -> [Char] -> [Char]
weird6 xs ys
    | length xs == 0 || length ys == 0 = ""
    | otherwise                        = (last xs):(last ys):weird6 (init xs) (init ys)

distance2 :: (Ord a, Floating a) => (a,a) -> (a,a) -> String
distance2 (x1, y1) (x2, y2)
   | dist < 1    = "Very Close"
   | dist < 5    = "Close"
   | dist < 100  = "Somewhat near"
   | otherwise   = "Far away"
   where dist    = sqrt ((x2 - x1)^2 + (y2 - y1)^2)

initials :: String -> String -> String
initials fn ln = (head fn):'.':(head ln):'.':[]

triBtwn :: (Ord a, Integral a) => a -> a -> [(a, a, a)]
triBtwn x y = filter (triangle) [(a,b,c) | a <- [x..y], b <- [x..y], c <- [x..y]]
    where triangle (a,b,c) = a + b > c

