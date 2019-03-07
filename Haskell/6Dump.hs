import Data.Char
import Data.List

triple1 (x,_,_) = x
triple2 (_,y,_) = y
triple3 (_,_,z) = z

giveName :: String -> String
giveName xs
    | xs == "Jaden"   = "First Name"
    | xs == "Nikkos"  = "Middle Name"
    | xs == "Leonard" = "Last Name"
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
    