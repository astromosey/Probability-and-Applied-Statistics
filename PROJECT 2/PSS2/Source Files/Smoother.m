function Smoother(fileName, windowValue, outputFileName)
    % Check if the output file name is provided
    if nargin < 3
        % If not, set default output file name
        outputFileName = 'SmoothedValues.csv';
    end

    % Read data from CSV file and store it in a matrix
    values = csvread(fileName);

    % Split the matrix 
    x = values(:,1);
    y = values(:,2);

    % Calculate moving averages for y values
    smoothedValues = movmean(y, windowValue);

    % Create new plot figure
    SmootherFigure = figure('name', 'Smoother');

    % Plot smoothed data
    plot(x, smoothedValues)
    
    % Plot title
    title({'Smoothed Data', ['(Window Size: ' num2str(windowValue) ')']});

    % Put data into matrix
    xy = [x(:), smoothedValues(:)];

    % Write data to CSV file
    writematrix(xy, outputFileName);
end
