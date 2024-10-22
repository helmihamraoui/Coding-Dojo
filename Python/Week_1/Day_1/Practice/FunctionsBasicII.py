def countdown(a):
    newliste=[]
    for i in range (a,-1,-1):
        newliste.append(i)
    print(newliste)
countdown(5)    
# *************************************************************************************
def Print_and_Return(liste):
    print (liste[0])
    return liste[1]
print(Print_and_Return([1,2]))
# ************************************************************************
def first_plus_length(liste):
    return liste[0]+len(liste)
print(first_plus_length([1,2,3,4,5]))
# ************************************************************************
def values_greater_than_second(liste):
    count=0
    newliste=[]
    if (len(liste)>1):
        temps=liste[1]
        for i in range (0,len(liste),1):
            if liste[i]>temps:
                count=count+1
                newliste.append(liste[i])
        print (count)
        return newliste
    else:
        return False
print(values_greater_than_second([5,2,3,2,1,4]))
# *************************************************************************************
def length_and_value(a,b):
    liste=[]
    for i in range (a):
        liste.append(b)
    return liste    
print(length_and_value(4,7))
print (length_and_value(6,2))