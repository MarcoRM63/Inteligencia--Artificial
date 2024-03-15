import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

pokemon = pd.read_csv('Pokemon.csv')


print(pokemon.head())

X = pokemon[['Sp. Def']]
Y = pokemon['Defense']
MPG_Pred = LinearRegression()
MPG_Pred.fit(X,Y)

plt.figure(figsize=(10,10))
plt.scatter(pokemon['Sp. Def'], pokemon['Defense'])
plt.scatter(X,MPG_Pred.predict(X), c='Red')
plt.title('SP DEFENSE vs. DEFENSE')
plt.xlabel('Sp. Def')
plt.ylabel('Defense')
plt.show()