# Author   : Emilio Velazquez-Carter
# Email    : evelazquezca@umass.edu
# Spire ID : 3420064


class VendingMachine:


    def __init__(self):
        self.inventory = {}
        self.balance = 0.0
        self.total_sales = 0.0
        self.sales_history = []

    def add_item(self, name, price, quantity):
        if name in self.inventory:
            self.inventory[name]['price'] = price
            self.inventory[name]['quantity'] += quantity
        else:    
            self.inventory[name] = {'price' : price, 'quantity' : quantity}
        
        print(f'{quantity} {name}(s) added to inventory.')


    def get_item_price(self, name):
        if name in self.inventory:
            return(self.inventory[name]['price'])
        else:
            print('Invalid item')
            return

    
    def get_item_quantity(self, name):
        if name in self.inventory:
            return(self.inventory[name]['quantity'])
        else:
            print('Invalid item')
            return


    def list_items(self):
        if len(self.inventory) == 0:
            print('No items in the vending machine')
        else:
            print('Available items:')
            sort_inv = sorted(self.inventory)    
            for item in sort_inv:
                price = self.inventory[item]['price']
                quantity = self.inventory[item]['quantity']
                print(f'{item} (${price}): {quantity} available')


    def insert_money(self, dollar_amount):
        if dollar_amount == 1.0:
            self.balance += dollar_amount
            print(f'Balance: {self.balance:.2f}')
        elif dollar_amount == 2.0:
            self.balance += dollar_amount
            print(f'Balance: {self.balance:.2f}')
        elif dollar_amount == 5.0:
            self.balance += dollar_amount
            print(f'Balance: {self.balance:.2f}')
        else:
            print('Invalid amount')

    def purchase(self, item_name):
        if item_name not in self.inventory:
            print('Invalid item')
        elif self.inventory[item_name]['quantity'] <= 0:
            print(f'Sorry {item_name} is out of stock')
        elif self.balance < self.inventory[item_name]['price']:
            print(f'Insufficient balance. Price of {item_name} is {self.inventory[item_name]['price']}')
        else:
            self.inventory[item_name]['quantity'] -= 1
            self.balance -= self.inventory[item_name]['price']
            print(f'Purchased {item_name}\nBalance: {self.balance:.2f}')
            self.total_sales += self.inventory[item_name]['price']
            self.total_sales = round(self.total_sales, 2)
            self.sales_history.append({
                'item_name' : item_name, 
                'price' : self.inventory[item_name]['price'], 
                'quantity' : 1
            })


    def output_change(self):
        if self.balance > 0:
            print(f'Change: {self.balance:.2f}')
            self.balance = 0.0
        else:
            print('No change')


    def remove_item(self, name):
        if name in self.inventory:
            self.inventory.pop(name)
            print(f'{name} removed from inventory')
        else:
            print('Invalid item')


    def empty_inventory(self):
        self.inventory.clear()
        print('Inventory cleared')
    

    def get_total_sales(self):
        return self.total_sales


    def stats(self, n):
        if len(self.sales_history) == 0:
            print('No sale history in the vending machine')
            return

        total_sales = {}
        recent_sales = self.sales_history[-n:]
        sorted_sales = sorted(recent_sales, key = lambda x: x['item_name'])

        for sale in sorted_sales:
            name = sale['item_name']
            if name not in total_sales:
                total_sales[name] = {'total_sales' : 0, 'purchases' : 0}
            total_sales[name]['total_sales'] += sale['price'] * sale['quantity']
            total_sales[name]['purchases'] += sale['quantity']

        print(f'Sale history for the most recent {len(recent_sales)} purchase(s):')
        for name, stats in total_sales.items():
            print(f'{name}: ${stats["total_sales"]:.2f} for {stats["purchases"]} purchase(s)')



#vending_machine(add_item('cracker', 10, 4))



#x=10
#print([f'