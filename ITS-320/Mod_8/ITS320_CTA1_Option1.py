import os


class Automobile:


    def __init__(self, make, model, color, year, mileage):
        self.make = make
        self.model = model
        self.color = color
        self.year = year
        self.mileage = mileage
    
    # Addvehicle method will take in the inputs for the user of the inputs for the new car.
    # addvehicels will return an instance of a car. this car is intended to be put in the list containing all the cars 
    def addVehicle(self):

        make = input("What is the make: ")
        model = input("What is the model: ")
        color = input("What is the color: ")
        year = int(input("What is the year: "))
        mileage = int(input("What is the mileage: "))
        
        cars2 = (Automobile(make, model, color, year, mileage))
        return cars2

        

    

    def updateVehicle():
        pass

    # This can print each individual car and the information
    def __str__ (self):
        return f'{self.make} {self.model} {self.color} {self.year} {self.mileage}'
    


# This will print to a text file to a document. 
def printToFile(garage):

    # This is the file path to where the text file will be placed
    file_path = os.path.join('C:\\', 'Users', 'bryan', 'Documents', 'garage2.txt')

    with open(file_path, 'w+') as txtFile:
        
        txtFile.write('False Garage')
        txtFile.seek(0)

        content = txtFile.read()



    print('%s: %s' % (file_path, content))
    txtFile.close()
    
    pass   

#This function will print the content of the current garage
def printGarage(garage):
    for car in garage:
        print(car)


# This method will 
def removeVehicle(garage):
        print("Which car would you like to remove, please input a number")
        i = 0
        for car in garage:
            print (str(i), end= '. ')
            print(car)
            i += 1
        choice = int(input())

        car = garage.pop(choice)
        print(f"Removed vehicle: {car}" )
        

garage = []
car1 = Automobile("Chevy","Cruz","Blue", 1995, 210000)
garage.append(car1)
garage.append(Automobile('Chevy' , 'Cobalt', 'Red', 2004, 147153))

# This is how to add car into the garage
# temp_car = Automobile("", "", "", 0, 0)
# garage.append(temp_car.addVehicle())

#removeVehicle(garage)

printGarage(garage)
printToFile(garage)


