Given an input stream **s** consisting only of **lowercase alphabets**. While reading characters from the stream, you have to tell which character has appeared **only once** in the stream upto that point. If there are many characters that have appeared only once, you have to tell which one of them was the **first one** to appear. If there is no such character, then append '**#**' to the answer.

NOTE:
1. You need to find the answer for **every i** (0 <= i < n)
2. In order to find the solution for every i, you need to consider the string from starting position till the i<sup>th</sup> position.

Constraints:
1 <= s.size()<= 10<sup>5</sup>
'a' <= s[i] <= 'z'
