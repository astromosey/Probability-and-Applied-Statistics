function Salter(fileName, saltMin, saltMax)
    % Read data from CSV file and store it in matrix
    values = readmatrix(fileName);
    
    % Split the matrix
    x = values(:,1);
    y = values(:,2);

    % Add/subtract random salt value
    for i = 1:length(y)
        % Generate random salt within specified range
        saltValue = (saltMax - saltMin).*rand(1) + saltMin;

        % Generate random integer
        randomNumber = int32(randi([0, 1]));

        % Add/subtract salt value based on the random number
        if randomNumber == 0
            y(i) = y(i) + saltValue;
        else
            y(i) = y(i) - saltValue;
        end
    end
    
    % Create new plot figure
    SalterFigure = figure('name', 'Salter');

    % Plot modified data
    plot(x, y)

    % Plot title 
    title({'Salted Data', ['(Salt Range: [' num2str(saltMin) ', ' num2str(saltMax) '])']});
    
    % Put data into matrix
    xy = [x(:), y(:)];

    % Write data to CSV file
    writematrix(xy, 'SaltedValues.csv')
end
