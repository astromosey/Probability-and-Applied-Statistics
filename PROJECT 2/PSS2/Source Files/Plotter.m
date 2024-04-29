function Plotter(fileName, min, max, increment)
    % Define the polynomial function: y = x^2 - 4x + 3
    p = [1 -4 3];

    % Generate x values from min to max with given increment
    x = min:increment:max;

    % Calculate corresponding y values based on the polynomial function
    y = polyval(p, x);

    % Create a new plotting figure
    PlottingFigure = figure('Name', 'Plotter');

    % Plot the function using x as x-axis values and y as y-axis values
    plot(x, y)

    % Plot title
    title({'Plotted Data', ['(Range: [' num2str(min) ', ' num2str(max) '])']});

    % Put data into matrix
    xy = [x;y];

    % Arrange x and y values in columns
    xy = xy';
    
    % Write data to CSV file
    writematrix(xy, fileName)
end
