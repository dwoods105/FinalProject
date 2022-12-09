#contour chart from video tutorial
#function returns z matrix
function z = _contourChart()
  #declare an x matrix
  x = [1 2 3 2 1];
  #create another matrix, y, equal to x
  y = x;
  #create a matrix z, that is the transpose of x multiplied by y
  z= x' * y;
  #print a contour chart
  contour(z);
  #set the axis to be between 1 and 5 on both axis.
  axis([1 5 1 5]);
  endfunction;

