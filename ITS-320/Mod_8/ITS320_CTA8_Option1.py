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
    

    def getMake(self, make):
        return self.make

    def getModel(self, model):
        return self.model

    def getColor(self, color):
        return self.color

    def getYear(self, year):
        return self.year
    
    def getMileage(self, mileage):
        return self.mileage
    
    def setMake(self, make):
        self.make = make

    def setModel(self, model):
        self.model = model

    def setColor(self, color):
        self.color = color

    def setYear(self, year):
        self.year = year
    
    def setMileage(self, mileage):
        self.mileage = mileage

    # This can print each individual car and the information
    def __str__ (self):
        return f'{self.make} {self.model} {self.color} {self.year} {self.mileage}'
    
# This method is to update certain details of a specific car.
# Because garage is a list, i will print out all the item led by a integer. 
# When the user sees the vehicle they want to update, they will enter the corresponding number
# This will then prompt the user again to pick which attribute they would like to update.
# They then will get to input the change.
def updateVehicle(garage):
        
        validInput = False;
        
        print("Which car are we updating the information")
        i = 0
        for car in garage:
            print (str(i), end= '. ')
            print(car)
            i += 1
        choiceCar = int(input())

        print("What would you like to update")
        print("1. Make\n2. Model\n3. Color\n4. Year\n5. Mileage")
        
        choiceVar = int(input())

        while(validInput == False):
         try:
            if choiceVar == 1:
                garage[choiceCar].setMake(input("What is the updated Make: "))
                validInput = True
            
            elif choiceVar == 2:
                garage[choiceCar].setModel(input("What is the updated Model: "))
                validInput = True

            elif choiceVar == 3:
                garage[choiceCar].setColor(input("What is the updated Color: "))
                validInput = True

            elif choiceVar == 4:
                garage[choiceCar].setYear(input("What is the updated Year: "))
                validInput = True

            elif choiceVar == 5:
                garage[choiceCar].setMileage(input("What is the updated Mileage: "))
                validInput = True
            else:
                print("Not a valid choice, please try again")
                validInput = False
         except ValueError:
            print("Invallid input. Please enter only numbers for years and mileage")

        print(f"Successfully updated {garage[choiceCar]}")

# This will print to a text file to a document. 
# Opens Creates a file in my Documents and prints what is in the garage list

def printToFile(garage):

    # This is the file path to where the text file will be placed
    file_path = os.path.join('C:\\', 'Users', 'bryan', 'Documents', 'garage_python.txt')

    with open(file_path, 'w+') as txtFile:
        
        for car in garage:
            txtFile.write(str(car) + '\n')

        #Need in case of overwriting
        txtFile.seek(0)
        content = txtFile.read()

    print('%s: %s' % (file_path, content))
    txtFile.close()   

#This function will print the content of the current garage
def printGarage(garage):
    for car in garage:
        print(car)


# This method will list every car lead by a number. 
# When the user sees what car they want to delete, they will enter the leading number
# The car that is deleted is then shown on screen with a message showing it has been deleted
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

# This method will need a garage input and add a car to the garage.
# it has a check to make sure the year and mileage are numbers.
# This will return a success when added

def addVehicle(garage):
    validInput = False
    while(validInput == False):
     try:
        make = input("What is the make: ")
        model = input("What is the model: ")
        color = input("What is the color: ")
        year = int(input("What is the year: "))
        mileage = int(input("What is the mileage: "))
        
        cars2 = (Automobile(make, model, color, year, mileage))
        print(f"Successfully added: {cars2}")
        validInput = True
        garage.append(cars2)      
     except ValueError:
        print("Invalid input: Please enter only numbers for years and mileage")


garage = []
validInput = False
choice = 0

print("Welcome to Bryan's Garage Inventory Space Program")
print("Here we hold specific information about cars you want to hold in inventory")
print("Here are your options")


while(validInput == False):
 try:
    choice = int(input(("1. Add Vehicle\n2. Remove vehicle\n3. Update car attribute\n4. Print content\n5. To quit\n")))
    if choice == 1:
        addVehicle(garage)
    
    elif choice == 2:
        removeVehicle(garage)

    elif choice == 3:
        updateVehicle(garage)

    elif choice == 4:
        printGarage(garage)

    elif choice == 5:
        validInput = True
    
    else:  
        print("Not a valid choice, please enter 1 - 6")
 except ValueError:
     print("Invalid inputs, Please only use numbers")

printToFile(garage)
