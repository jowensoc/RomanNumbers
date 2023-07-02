# Roman Numbers

## Overview

This was a group exercise with junior consulants, The Fellowship Meetup, where we all got the inital unit tests working. 
I took a copy of the original code and expanded it, by adding more numeral numbers in RomanNumeralsService.

I've refactored the original service into a new service, RomanNumeralFilterService to test out an idea; splitting the number into digits 
and build up a Roman number on each digit

## RomanNumeralsService 

This was the original service we've worked on. It had a limited set of roman numerals. Unit tests worked initially, 
before we ran out of time.

## RomanNumeralsFilterService 

I've refactored the original RomanNumeralsService into this new service. In this service, I've created a function 
to split each digit in the number into each Roman Number, append each Roman numeral to a string and then finally
display the output.

My consideration was to split each digit into a unit type such as Thousands, Hundreds or Singles. For example, the number 
1995 becomes 1000 (Thousands), 900 (Hundreds), 90 (Tens), 5 (Singles). This service has a filter where it will
search for each digit and its unit type e.g. the digit 1, unit type Hundreds, then retrieve the Roman Numeral.

The reason I took this filter approach was to make it easier to identify the digit and unit type to get the roman numeral. 
For example, the number 1995. When we parse the second digit 9, the code may identify the roman numeral as IX, 
but the number was actually 900 where the code should have returned XC as a Roman numeral.

My approach may be over-engineered and may not be the correct way to use. It was a good exercise learning how to use filtering in Scala

## Caveats
The code will reject any negative numbers and any submitted numbers from 5000 and beyond.

### The Fellowship Meetup

Team members who've worked on this group exercise

- Carl Thompson
- Hannah Ellis
- Ioannis Lazaridis
- John Owens
- Joseph Scott-Hartley
- Marcy Calderon Patino
- Rabina Rai
- Twinkle Lahariya


