"""Functions to manage a users shopping cart items."""


def add_item(current_cart, items_to_add):
    """Add items to shopping cart.

    Parameters:
        current_cart (dict): The current shopping cart.
        items_to_add (iterable): The items to add to the cart.

    Returns:
        dict: The updated user cart dictionary.
    """
    
    for item in items_to_add:
        current_cart[item] = current_cart.get(item, 0)+1 #.get covers old and new item with no errors
    return current_cart
        


def read_notes(notes):
    """Create user cart from an iterable notes entry.

    Parameters:
        notes (iterable): Group of items to add to cart.

    Returns:
        dict: A user shopping cart dictionary.
    """
    cart = dict.fromkeys(notes, 1)
    return cart
        


def update_recipes(ideas, recipe_updates):
    """Update the recipe ideas dictionary.

    Parameters:
        ideas (dict): The "recipe ideas" dict.
        recipe_updates (iterable): Updates for the ideas section.

    Returns:
        dict: The updated "recipe ideas" dict.
    """
    ideas |= recipe_updates 
    return ideas


def sort_entries(cart):
    """Sort a user's shopping cart in alphabetical order.

    Parameters:
        cart (dict): A user's shopping cart dictionary.

    Returns:
        dict: A user's shopping cart sorted in alphabetical order.
    """

    cart = dict(sorted(cart.items()))
    return cart


def send_to_store(cart, aisle_mapping):
    """Combine user's order to aisle and refrigeration information.

    Parameters:
        cart (dict): The user's shopping cart dictionary.
        aisle_mapping (dict): The aisle and refrigeration information dictionary.

    Returns:
        dict: The fulfillment dictionary ready to send to store.
    """
    fulfillment_cart = {}
    sorted_items = sorted(cart.keys(), reverse=True)
    for item in sorted_items:
        quantity = cart[item]
        location_info = aisle_mapping[item]         
        fulfillment_cart[item] = [quantity] + location_info

    return fulfillment_cart


def update_store_inventory(fulfillment_cart, store_inventory):
    """Update store inventory levels with user order.

    Parameters:
        fulfillment cart (dict): The fulfillment cart to send to store.
        store_inventory (dict): The stores available inventory.

    Returns:
        dict: The store_inventory updated.
    """  
    for item, order_info in fulfillment_cart.items():  #unpack to tuples (item and info-list)    
        store_inventory[item][0] -= order_info[0]      #subtract order from inv
        if store_inventory[item][0] <= 0:
            store_inventory[item][0] = 'Out of Stock'
    
    return store_inventory
