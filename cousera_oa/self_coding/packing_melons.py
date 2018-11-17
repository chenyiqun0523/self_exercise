import sys
import os

###

def melon_count(boxes,melons):
     boxes.sort();
     melons.sort();

     result = 0;
     i = 0;
     j = 0;

     while(i != boxes.__len__() and j != melons.__len__()):
          if boxes[i] >= melons[j]:

               result = result+1;
               i = i+1;
               j= j+1;
          else:

               i = i+1;


     return result;

###