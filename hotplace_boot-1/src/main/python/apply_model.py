
import numpy as np;
import pandas as pd;
import pickle;
import matplotlib.pyplot as plt
from sklearn.ensemble import GradientBoostingClassifier
import seaborn as sns
import sklearn

print(np.__version__)
print(sklearn.__version__)

model_col = ['age', 'cfam', 'educ', 'occp', 'EC_wht_23', 'L_OUT_FQ', 'L_DN_WHO',
       'marri_2_1.0', 'marri_2_2.0', 'marri_2_3.0', 'marri_2_4.0',
       'marri_2_88.0', 'marri_2_99.0', 'genertn_1.0', 'genertn_2.0',
       'genertn_3.0', 'genertn_4.0', 'genertn_5.0', 'genertn_6.0',
       'genertn_7.0', 'EC_wht_5_1.0', 'EC_wht_5_2.0', 'EC_wht_5_3.0',
       'EC_wht_5_4.0', 'EC_wht_5_5.0']#'EC_wht_5_6.0', 'EC_wht_5_7.0',      'EC_wht_5_88.0']

#명목형 범주
onehot_cate = ['marri_2','genertn','EC_wht_5','L_DN_WHO']

#순서형 범주
order_cate = ['educ','occp','L_OUT_FQ']

#연속형 변수
numeric_col = ['age','cfam','EC_wht_23']

data= np.array([39,1,5,4,7,2,40,1,3,1])
test_col =['age', 'marri_2', 'cfam', 'genertn', 'educ', 'occp', 'EC_wht_23','EC_wht_5', 'L_OUT_FQ','L_DN_WHO']

test = pd.DataFrame(data.reshape(1,-1), columns = test_col)
test = test.astype('float64')

#없는칼럼 생성
test[np.setdiff1d(np.array(model_col), np.array(test.columns))]=0

# #연속형 변수 (나이, 주 근로시간, 가족 구성원수) 스케일링
#test[numeric_col] = std.transform(test[numeric_col])

with open('C:\\Users\\BIFF2020\\Desktop\\bnkBankProject20220915pfin\\hotplace_boot-1\\src\\main\\python\\model_LN_2.pkl', 'rb') as f:
    model = pickle.load(f)

print(model.predict(test.drop('L_DN_WHO',axis=1)))