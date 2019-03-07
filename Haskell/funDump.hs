import Data.Char 
import Data.List

--Field Vars
zero10 = [0..10]
atoz = ['a'..'z']

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

badAvg :: (Real a) => [a] -> Float
badAvg xs = (sum xs) / (length xs)

xsToNums :: [[Char]] -> [Double]
xsToNums xs = [read xs :: Double | x <- xs]
