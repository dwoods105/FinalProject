function data = csv_plot()
  #this statement creates a file ID that is required for the fscanf function
  #to open the file and get the data
  fid = fopen('testData.csv','r');
  #This reads the 2 columns from the file and adds it to a variable
  #named file as a matrix
  file = fscanf(fid,'%f %f',[2 11]);
  #this transposes the data in the matrix and stores it in a matrix called data
  data = file'
  #this gets all the values in the first column of data and creates an array
  #named x with it.
  x = data(:,1);
  #this does the same thing but uses the second column and for the y values
  y = data(:,2);
  #creates and prints the plot.
  plot(x,y);
  endfunction;

