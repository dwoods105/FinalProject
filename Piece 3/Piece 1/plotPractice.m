#The pdf tutorial I used has a section on page 17 which
#talks about plotting points and creating graphs.
#page 29 talks about how to declare a function

#function _graphsin takes a variable that will be
#the coefficient of x in the sin(x) equation
#the function will display a graph on the interval
#(-10<x<10)

#the y is the return variable,
#_graphsin is the name and x_coef is the parameter, the 1 is the default parameter.
function y = _graphsin(x_coef=1)
  #colon notation variables as described on page 14
  x=[-10:.01:10];
  #defining y
  y=sin(x_coef*x);
  #command to plot
  plot(x,y);
  #the very plain x label for the x axis
  xlabel("x");
  #concatenating the y label to provide the coefficient for x in the label
  #you have to add 48 becaause it encodes in UTF-8
  ylab = ["sin(" char(x_coef+48) "x)"];
  titleconcat = ["Line Plot of sin(" char(x_coef+48) "x)"];
  #adds a title to the chart
  title(titleconcat);
  #adds a y label
  ylabel(ylab);
  #turns the grid on so it's more visible
  grid on;
  endfunction;
