# Roman Numbers

## Overview

This was a group exercise with junior consulants, The Fellowship Meetup, where we all got the inital unit tests working. 
I took a copy of the original code and expanded it, by adding more numeral numbers in RomanNumeralsService.

I've refactored the original service into a new service, RomanNumeralFilterService to test out an idea; splitting the number into digits and on each digit, we append the Roman number to a string

## RomanNumeralsService 

This was the original service we've worked on. It had a limited set of roman numerals. Unit tests worked initially, 
before we ran out of time on the exercise.

## RomanNumeralsFilterService 

I've refactored the original RomanNumeralsService into this new service. In this service, I've created a function 
to split each digit in the number into each Roman Numeral, append each Roman numeral to a string and then finally
display the output.

My consideration was to split each digit into a unit type such as Thousands, Hundreds or Singles. For example, the number 1995 becomes 1000 (Thousands), 900 (Hundreds), 90 (Tens), 5 (Singles). This service has a filter where it will
search for each digit and its unit type e.g. search for the digit 1 and unit type Thousands, which should retrieve the Roman Numeral M.

The reason I took this filter approach was to make it easier to identify the digit and unit type to get the correct Roman Numeral. 
For example, the number 1995. When we parse the second digit 9, the code may identify 9, as the roman numeral IX, 
but the number was 900 where the code should have returned XC as a Roman numeral. This is why I added unit types to easily identify the correct Roman Numeral

My approach for RomanNumeralsFilterService may be over-engineered and may not be the correct way to use. It was a good exercise learning how to use filter in Scala

## Caveats
The code will reject any negative numbers and any numbers from 5000 and beyond. You will recieve an "OUT_OF_RANGE" text back.

### The Fellowship Meetup

Team members who have worked on this group exercise

- Carl Thompson
- Hannah Ellis
- Ioannis Lazaridis
- John Owens
- Joseph Scott-Hartley
- Marcy Calderon Patino
- Rabina Rai
- Twinkle Lahariya


