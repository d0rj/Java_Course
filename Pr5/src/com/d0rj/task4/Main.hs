module Task4 where


digitsSum :: Integer -> Integer
digitsSum n = helper 0 n
  where helper sum n
          | n == 0    = sum
          | otherwise = helper (sum + (rem n 10)) (quot n 10)

solve :: Integer -> Integer -> Integer
solve k s = helper (10^(k - 1)) 0 k s
  where helper number count k s
          | number == (10^k)         = count
          | (digitsSum number) == s = helper (number + 1) (count + 1) k s
          | otherwise               = helper (number + 1) count k s
