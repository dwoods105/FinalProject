# This function reads a data set I got from the New York Times on covid cases
# over time. I had to scrub the data because it's much easier to plot scrubbed
# data in octave than do string comparison. I opened the CSV in excel and
# totaled all of the covid cases up by date. I then converted the date into an
# integer value and imported the file here.
# The original data can be obtained from
# https://github.com/nytimes/covid-19-data/blob/master/us-counties-2020.csv
function file = plotCovCases()
  #csv read function builtin to Octave, reads into file variable
  file=csvread('scrubbeddata.csv');
  #grab the date value column and create x array with it
  x = file(:,1);
  #grab the case count column and create y array with it.
  y = file(:,2);
  #salt the data and assign the salted data to x1 and y1
  [x1,y1]=Salt(x,y);
  #smooth the data and assign the data to x2 and y2
  [x2,y2]=Smooth(x,y);
  #create the plot of all the data
  #there are 3 lines on this chart. The salt is visible but for the
  #smooth, you have to zoom in a lot because I chose a massive data set
  #the lines just pick a random color.
  plot(x,y,x1,y1,x2,y2);
  hold on;
  #add axis label
  ylabel("Covid Cases");
  #add axis label
  xlabel("Date Value");
  #add title
  title("Covid Cases by Date in US");

endfunction;
#this function takes 2 arrays of x and y values and returns the
#arrays as salted data
function [x1,y1] = Salt(x,y)
  x1 = x;
  y1 = y;
  #for the length of y
  for i=1:length(y);
    #add a random number between 0 and 10 million
    #I had to use a giant number because my dataset is giant
  random = randi([0,10000000]);
  y1(i) = random+y(i);
  endfor;
endfunction;
#this function takes 2 arrays of x and y values and returns 2 arrays of smoothed
#x and y arrays
function [x2,y2] = Smooth(x,y)
  x2 = x;
  y2 = y;
  #iterate through each value of Y
  for i=1:length(y);

  switch(i)
  # this switch ensures we dont have an out of bounds, we are smoothing with
  #11 values. I did so many because my dataset is huge and this is enough to
  #just see the smooth if you zoom in.
    case 1
      y2(i)=(y(i+1)+y(i+2)+y(i+3)+y(i+4)+y(i+5)+y(i+6)+y(i+7)+y(i+8)+y(i+9)+y(i+10)+y(i))/11;
    case 2
      y2(i)=(y(i+1)+y(i+2)+y(i+3)+y(i+4)+y(i+5)+y(i+6)+y(i+7)+y(i+8)+y(i+9)+y(i)+y(i-1))/11;
    case 3
      y2(i)=(y(i+1)+y(i+2)+y(i+3)+y(i+4)+y(i+5)+y(i+6)+y(i+7)+y(i+8)+y(i)+y(i-2)+y(i-1))/11;
    case 4
      y2(i)=(y(i+1)+y(i+2)+y(i+3)+y(i+4)+y(i+5)+y(i+6)+y(i+7)+y(i)+y(i-3)+y(i-2)+y(i-1))/11;
    case 5
      y2(i)=(y(i+1)+y(i+2)+y(i+3)+y(i+4)+y(i+5)+y(i+6)+y(i)+y(i-4)+y(i-3)+y(i-2)+y(i-1))/11;
    case 6
      y2(i)=(y(i+1)+y(i+2)+y(i+3)+y(i+4)+y(i+5)+y(i)+y(i-5)+y(i-4)+y(i-3)+y(i-2)+y(i-1))/11;
    case length(y)
      y2(i)=(y(i-1)+y(i-2)+y(i-3)+y(i-4)+y(i-5)+y(i-6)+y(i-7)+y(i-8)+y(i-9)+y(i-10)+y(i))/11;
    case length(y)-1
      y2(i)=(y(i+1)+y(i)+y(i-9)+y(i-8)+y(i-7)+y(i-6)+y(i-5)+y(i-4)+y(i-3)+y(i-2)+y(i-1))/11;
    case length(y)-2
      y2(i)=(y(i+1)+y(i+2)+y(i)+y(i-7)+y(i-6)+y(i-5)+y(i-4)+y(i-3)+y(i)+y(i-2)+y(i-1))/11;
    case length(y)-3
      y2(i)=(y(i+1)+y(i+2)+y(i+3)+y(i)+y(i-7)+y(i-6)+y(i-5)+y(i-4)+y(i-3)+y(i-2)+y(i-1))/11;
    case length(y)-4
      y2(i)=(y(i+1)+y(i+2)+y(i+3)+y(i+4)+y(i)+y(i-6)+y(i-5)+y(i-4)+y(i-3)+y(i-2)+y(i-1))/11;
    case length(y)-5
      y2(i)=(y(i+1)+y(i+2)+y(i+3)+y(i+4)+y(i+5)+y(i)+y(i-5)+y(i-4)+y(i-3)+y(i-2)+y(i-1))/11;
      #this otherwise does most of the work.
    otherwise
      y2(i)=(y(i+1)+y(i+2)+y(i+3)+y(i+4)+y(i+5)+y(i)+y(i-5)+y(i-4)+y(i-3)+y(i-2)+y(i-1))/11;
  endswitch;
  endfor;
  endfunction;

