import pandas as pd
import numpy as np

from sklearn.model_selection import train_test_split
from sklearn.ensemble import GradientBoostingRegressor as gbr
from sklearn.metrics import f1_score

class predict_humidity():
    def __init__(
        self, 
        previos_data: pd.DataFrame,
        fit = False
        )-> predict_humidity:
        self.previos_data = previos_data
        self.is_fitted = False
        if fit :
            self.fit(self.previos_data)
        return self

    def fit(previos_data: pd.DataFrame):
        
        labels = previos_data[previos_data.columns[-1]]
        tabel = previos_data[previos_data.columns[:-1]]
        
        X_train, X_test, y_train, y_test = train_test_split(tabel, labels, test_size=0.33, random_state=42)
        
        self.predictor = gbr()

        self.predictor.fit(X_train, y_test)

        self.f1_score = f1_score(y_test, self.predictor.predict(X_test))

        self.is_fitted = True

        return self
    
    def predict(self, data: pd.DataFrame or np.ndarray):
        if not self.is_fitted:
            raise Exception("not fitted")
        else:
            if self.f1_score<0.9:
                raise Exception("bad accuricy")
            else:
                return self.predictor.predict(data)
class predict_temperatur():
    def __init__(
        self, 
        previos_data: pd.DataFrame,
        fit = False
        )-> predict_humidity:
        self.previos_data = previos_data
        self.is_fitted = False
        if fit :
            self.fit(self.previos_data)
        return self

    def fit(previos_data: pd.DataFrame):
        
        labels = previos_data[previos_data.columns[-1]]
        tabel = previos_data[previos_data.columns[:-1]]
        
        X_train, X_test, y_train, y_test = train_test_split(tabel, labels, test_size=0.33, random_state=42)
        
        self.predictor = gbr()

        self.predictor.fit(X_train, y_test)

        self.f1_score = f1_score(y_test, self.predictor.predict(X_test))

        self.is_fitted = True
        
        return self
    
    def predict(self, data: pd.DataFrame or np.ndarray):
        if not self.is_fitted:
            raise Exception("not fitted")
        else:
            if self.f1_score<0.9:
                raise Exception("bad accuricy")
            else:
                return self.predictor.predict(data)
