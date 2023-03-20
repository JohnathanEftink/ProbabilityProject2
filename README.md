# ProbabilityProject2
This is so that we can add any code we make here and easily share it and make changes as necessary

Group Members:
- Maxwell Penders (pye3yh)
- Johnathan Eftink (cvd2wa)


Write Up:
Firstly, the random number generator uses an algorithm called Linear Congruential Generator (LCG). An LCG is given a 
starting value (seed), a multiplier, an increment, and a modulous. These are then combined into the equation of 
x_2 = (a * x_1 + c) % K. This produces psudorandom values, and ideally will only repeat after K iterations of generating
a number. The values of U_51, is 0.515708923398438, U_52 is 0.427276611328125, and U_53 is 0.7681961059570312. These
U values are then used to determine what occurs. In deciding if the call is busy, unavailable, or available, this value
is compared to a set of ranges. if U is between 0 and 0.2, then it is busy, if it is between 0.2 and 0.5, then it is 
unavailable, and 0.5 to 1 is available. When the random number is used to generate the call time for available 
(max please explain this part because im not sure I fully understand it. I can explain it if you want me to tho)

For the 500 iterations of W we followed our tree diagram. That is to say that we used the 