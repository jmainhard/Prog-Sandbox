	if (guessed)
	{
		cout << "Número adivinado!" << LINE_BR;
		drawHTMLnumGuess(numToGuess, savedNumber);
	}
	else
	{
		cout << "Número NO adivinado!" << LINE_BR;
		drawHTMLnumGuess(numToGuess, savedNumber);
	}