# OrcoStat
### Analytic tool of negatively alive orcs and their equipment

# 1. Business logic
### Count negatively alive orcs
1. Every Orc has orcish name and orcish surname
2. Orc name can be either man or woman

### Count destroyed technics
1. Technic types
    1. Tank
    2. UAV (Drone)
    3. Missile
    4. ...
2. Technic can have equipage, but can be also abandoned
    1. Equipage loss increments orcs as well
    2. Number of technic equipage is dynamic
    3. Equipage size has realistic limits
        1. Tank contains 0 to 6 orcs
        2. ...

### Show statistic

# 2. Input
### Console application with infinite prompt loop
1. Input supports four commands
    1. Add orc
    2. Add tank
        - Specify orcs count
    3. Add missile
       ... Add ...
    4. Show damage
        - Specify period (total | daily)
    5. Show statistic
        - Specify period (total | daily)
    6. Exit
2. After illegal input say sorry and prompt input again


# Output
### Provide ability to print statistic table for period
1. Table header contains period info and loss type details: raw + chart
2. Supported periods
    1. Total
    2. Daily
3. Raw numbers as plain text
4. ASCII chart for selected period
    1. Max length of chart bar is 100 #
    2. Max number fills entire chart
    3. Other numbers are proportional
    4. Counting starts from 0. Print dash when zero

### 3. Output examples

<details>
<summary>Daily loss statistic examples</summary>

| period     | troops count | troops chart                                                                                         |
|------------|--------------|------------------------------------------------------------------------------------------------------|
| ...        | ...          | ...                                                                                                  | 
| 2022-11-14 | 510          | ########################################################################                             | 
| 2022-11-15 | 710          | #################################################################################################### | 
| 2022-11-16 | 630          | #########################################################################################            | 
| 2022-11-17 | 400          | ########################################################                                             | 
| 2022-11-18 | 350          | #################################################                                                    | 
| 2022-11-19 | 420          | ###########################################################                                          | 
| 2022-11-20 | 330          | ##############################################                                                       |

| period     | tanks count | tanks chart                                                                                          |
|------------|-------------|------------------------------------------------------------------------------------------------------|
| ...        | ...         | ...                                                                                                  | 
| 2022-11-14 | 8           | ##############################################################                                       | 
| 2022-11-15 | 13          | #################################################################################################### | 
| 2022-11-16 | 10          | #############################################################################                        | 
| 2022-11-17 | 7           | ######################################################                                               | 
| 2022-11-18 | 1           | ########                                                                                             | 
| 2022-11-19 | 6           | ##############################################                                                       | 
| 2022-11-20 | 1           | ########                                                                                             | 

| period     | missiles count | missiles chart                                                                                       |
|------------|----------------|------------------------------------------------------------------------------------------------------|
| ...        | ...            | ...                                                                                                  | 
| 2022-11-14 | 0              | -                                                                                                    | 
| 2022-11-15 | 0              | -                                                                                                    | 
| 2022-11-16 | 75             | #################################################################################################### | 
| 2022-11-17 | 0              | -                                                                                                    | 
| 2022-11-18 | 6              | ##########                                                                                           | 
| 2022-11-19 | 0              | -                                                                                                    | 
| 2022-11-20 | 0              | -                                                                                                    |

| period     | uav count | uav chart                                                                                            |
|------------|-----------|------------------------------------------------------------------------------------------------------|
| ...        | ...       | ...                                                                                                  | 
| 2022-11-14 | 2         | ##############                                                                                       | 
| 2022-11-15 | 2         | ##############                                                                                       | 
| 2022-11-16 | 14        | #################################################################################################### | 
| 2022-11-17 | 6         | ###########################################                                                          | 
| 2022-11-18 | 5         | ####################################                                                                 | 
| 2022-11-19 | 0         | -                                                                                                    | 
| 2022-11-20 | 1         | #######                                                                                              | 
</details>

<details>
<summary>Daily money statistic example</summary>

| period     | money        | money chart                                                                                          |
|------------|--------------|------------------------------------------------------------------------------------------------------|
| ...        | ...          | ...                                                                                                  | 
| 2022-11-14 | 34 200 000$  | #######                                                                                              | 
| 2022-11-15 | 53 200 000$  | ###########                                                                                          | 
| 2022-11-16 | 492 600 000$ | #################################################################################################### | 
| 2022-11-17 | 29 000 000$  | ######                                                                                               | 
| 2022-11-18 | 46 000 000$  | #########                                                                                            | 
| 2022-11-19 | 26 400 000$  | #####                                                                                                | 
| 2022-11-20 | 9 600 000$   | ##                                                                                                   |

</details>