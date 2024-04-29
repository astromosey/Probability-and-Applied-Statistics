% Call the Plotter function
Plotter('PlottedValues.csv', -10, 10, 0.1)

% Call the Salter function
Salter('PlottedValues.csv', 0, 250)

% Call the Smoother function
Smoother('SaltedValues.csv', 8, 'SmoothedValues1.csv')

% Call the Smoother function to smooth "SmoothedValues1.csv" and generate "SmoothedValues2.csv"
Smoother('SmoothedValues1.csv', 8, 'SmoothedValues2.csv');

% Call the Smoother function to smooth "SmoothedValues2.csv" and generate "SmoothedValues3.csv"
Smoother('SmoothedValues2.csv', 8, 'SmoothedValues3.csv');