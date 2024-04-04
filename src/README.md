# CS611-Assignment: MonstersAndHeroes

## Zhaozhan Huang
## zhzh@bu.edu
## U03088498

## file
/character/Attribute.java: Class managing hero or monster attributes
/character/FactoryHero.java: Class creating hero
/character/Hero.java: Class of a hero
/character/Monster.java: Class of a monster
/character/Inventory.java: Class of a hero's inventory
/character/Level.java: Class managing a hero's level. Observer Pattern. 
/character/Team.java: Class of a team that contains multiple Heroes.

/data/*.txt: Raw data of characters / Items

/event/Event.java: Class of an event. An event is bind to a tile in grid
/event/EventBattle.java: Class of a battle 
/event/EventMarket.java: Class of a market 
/event/FactoryEventBattle.java: Class to create an EventBattle. Factory Pattern
/event/EventBattle.java: Class to create an EventBattle. Factory Pattern

/grid/Grid.java: Class storing the game board information
/grid/Tile.java: Class storing a tile. Base class.
/grid/TileBlock.java: Class storing a block tile. Subclass.
/grid/TileBorder.java: Class storing a border tile. Subclass.
/grid/TileCommon.java: Class storing a common tile. Subclass.
/grid/TileMarket.java: Class storing a market tile. Subclass.

/item/Item: Class of an item. An item is stored in either FactoryEventMarket or a hero's inventory.
/item/Item*: The specific item.

/utility/Color: Class that handles printing with color
/utility/InputHandler: Class that collect user input. Singleton Pattern/
/utility/Observer: Interface that a observer should implement
/utility/Subject: Interface that the class being observed should inplement
/utility/Rand: Class that handle random numbers.

/Enum*: enum class

/Game: Class that handles the game cycle
/Menu: Class that maintains a menu layer in the game cycle
/Main: The main entrance


## Example IO
```text
==========MAIN MENU==========
Input options: <1> - New Game, <q> - Exit
=============================
1
You started a new game!
Please input the number of rows: (5~10):? Enter your input: 5
Please input the number of columns: (5~10):? Enter your input: 5
Please input the number of heroes: (1~4):? Enter your input: 2
<Hero>
<Attribute>
	Health==100
	Mana==400
	Strength==800
	Agility==400
	Dexterity==700
	Defense==0
</Attribute>
level: character.Level@7b84de
type: Warriors
</Hero>

<Hero>
<Attribute>
	Health==100
	Mana==400
	Strength==400
	Agility==400
	Dexterity==400
	Defense==0
</Attribute>
level: character.Level@1ee733d
type: Paladins
</Hero>

A new grid has been successfully initialized!
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
|X |M |/ |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |/ |  |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |/ |  |M |M |M |X |
+--+--+--+--+--+--+--+
|X |/ |/ |/ |  |H |X |
+--+--+--+--+--+--+--+
|X |M |  |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
Detailed View:
+--+--+--+
|M |M |X |
+--+--+--+
|  |H |X |
+--+--+--+
|/ |  |X |
+--+--+--+
Input options: <w/a/s/d> - move, <i> - show inventory, <m> - map, <h> - hero stats, <t> - trade, <c> - change inventory, <p> - drink potion, <q> - back to menu, <q> - Exit
d
Invalid choice: The team can't move to a block or a border.
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
|X |M |/ |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |/ |  |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |/ |  |M |M |M |X |
+--+--+--+--+--+--+--+
|X |/ |/ |/ |  |H |X |
+--+--+--+--+--+--+--+
|X |M |  |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
Detailed View:
+--+--+--+
|M |M |X |
+--+--+--+
|  |H |X |
+--+--+--+
|/ |  |X |
+--+--+--+
Input options: <w/a/s/d> - move, <i> - show inventory, <m> - map, <h> - hero stats, <t> - trade, <c> - change inventory, <p> - drink potion, <q> - back to menu, <q> - Exit
w
========MARKET========
What item do you want to buy?
Please select an option:
1. <Item>
	name: Flame_Tornado
	price: 700
	required_level: 4
	type: FireSpells
</Item>
<Additional Data>
	damage: 850
	mana_cost: 300
</Additional Data>
2. <Item>
	name: Thunder_Blast
	price: 750
	required_level: 4
	type: LightningSpells
</Item>
<Additional Data>
	damage: 950
	mana_cost: 400
</Additional Data>
3. <Item>
	name: Mermaid_Tears
	price: 850
	required_level: 5
	type: Potions
</Item>
<Additional Data>
	attribute_affected: Health/Mana/Strength/Agility
	attribute_increase: 100
</Additional Data>
4. <Item>
	name: Full_Body_Armor
	price: 1000
	required_level: 8
	type: Armory
</Item>
<Additional Data>
	damage_reduction: 1100
</Additional Data>
5. <Item>
	name: Axe
	price: 550
	required_level: 5
	type: Weaponry
</Item>
<Additional Data>
	damage: 850
	required_hands: 1
</Additional Data>
<1~9> - <Select this item>, <0> - <Cancel and return>
Enter the number of your choice: 5
-> You successfully bought an item! Check it in the inventory.
The item is <Item>
	name: Axe
	price: 550
	required_level: 5
	type: Weaponry
</Item>
<Additional Data>
	damage: 850
	required_hands: 1
</Additional Data>

Which item do you want to buy?
Please select an option:
1. <Item>
	name: Flame_Tornado
	price: 700
	required_level: 4
	type: FireSpells
</Item>
<Additional Data>
	damage: 850
	mana_cost: 300
</Additional Data>
2. <Item>
	name: Thunder_Blast
	price: 750
	required_level: 4
	type: LightningSpells
</Item>
<Additional Data>
	damage: 950
	mana_cost: 400
</Additional Data>
3. <Item>
	name: Mermaid_Tears
	price: 850
	required_level: 5
	type: Potions
</Item>
<Additional Data>
	attribute_affected: Health/Mana/Strength/Agility
	attribute_increase: 100
</Additional Data>
4. <Item>
	name: Full_Body_Armor
	price: 1000
	required_level: 8
	type: Armory
</Item>
<Additional Data>
	damage_reduction: 1100
</Additional Data>
5. <Item>
	name: Axe
	price: 550
	required_level: 5
	type: Weaponry
</Item>
<Additional Data>
	damage: 850
	required_hands: 1
</Additional Data>
<1~9> - <Select this item>, <0> - <Cancel and return>
Enter the number of your choice: 0
You decided not to make a selection.
========LEAVE MARKET========
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
|X |M |/ |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |/ |  |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |/ |  |M |M |H |X |
+--+--+--+--+--+--+--+
|X |/ |/ |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |M |  |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
Detailed View:
+--+--+--+
|  |M |X |
+--+--+--+
|M |H |X |
+--+--+--+
|  |M |X |
+--+--+--+
Input options: <w/a/s/d> - move, <i> - show inventory, <m> - map, <h> - hero stats, <t> - trade, <c> - change inventory, <p> - drink potion, <q> - back to menu, <q> - Exit
a
========MARKET========
What item do you want to buy?
Please select an option:
1. <Item>
	name: Breath_of_Fire
	price: 350
	required_level: 1
	type: FireSpells
</Item>
<Additional Data>
	damage: 450
	mana_cost: 100
</Additional Data>
2. <Item>
	name: Spark_Needles
	price: 500
	required_level: 2
	type: LightningSpells
</Item>
<Additional Data>
	damage: 600
	mana_cost: 200
</Additional Data>
3. <Item>
	name: Mermaid_Tears
	price: 850
	required_level: 5
	type: Potions
</Item>
<Additional Data>
	attribute_affected: Health/Mana/Strength/Agility
	attribute_increase: 100
</Additional Data>
4. <Item>
	name: Wizard_Shield
	price: 1200
	required_level: 10
	type: Armory
</Item>
<Additional Data>
	damage_reduction: 1500
</Additional Data>
5. <Item>
	name: TSwords
	price: 1400
	required_level: 8
	type: Weaponry
</Item>
<Additional Data>
	damage: 1600
	required_hands: 2
</Additional Data>
<1~9> - <Select this item>, <0> - <Cancel and return>
Enter the number of your choice: 0
You decided not to make a selection.
========LEAVE MARKET========
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
|X |M |/ |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |/ |  |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |/ |  |M |H |M |X |
+--+--+--+--+--+--+--+
|X |/ |/ |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |M |  |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
Detailed View:
+--+--+--+
|/ |  |M |
+--+--+--+
|M |H |M |
+--+--+--+
|/ |  |M |
+--+--+--+
Input options: <w/a/s/d> - move, <i> - show inventory, <m> - map, <h> - hero stats, <t> - trade, <c> - change inventory, <p> - drink potion, <q> - back to menu, <q> - Exit
i
Now showing inventory of hero 1
<Item>
	name: Axe
	price: 550
	required_level: 5
	type: Weaponry
</Item>
<Additional Data>
	damage: 850
	required_hands: 1
</Additional Data>
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
|X |M |/ |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |/ |  |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |/ |  |M |H |M |X |
+--+--+--+--+--+--+--+
|X |/ |/ |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |M |  |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
Detailed View:
+--+--+--+
|/ |  |M |
+--+--+--+
|M |H |M |
+--+--+--+
|/ |  |M |
+--+--+--+
Input options: <w/a/s/d> - move, <i> - show inventory, <m> - map, <h> - hero stats, <t> - trade, <c> - change inventory, <p> - drink potion, <q> - back to menu, <q> - Exit
h
Status of hero No.1
hero name: Undefeated_Yoj
<Hero>
<Attribute>
	Health==100
	Mana==400
	Strength==800
	Agility==400
	Dexterity==700
	Defense==0
</Attribute>
level: character.Level@7b84de
type: Warriors
</Hero>

Status of hero No.2
hero name: Caliber_Heist
<Hero>
<Attribute>
	Health==100
	Mana==400
	Strength==400
	Agility==400
	Dexterity==400
	Defense==0
</Attribute>
level: character.Level@1ee733d
type: Paladins
</Hero>

+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
|X |M |/ |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |/ |  |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |/ |  |M |H |M |X |
+--+--+--+--+--+--+--+
|X |/ |/ |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |M |  |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
Detailed View:
+--+--+--+
|/ |  |M |
+--+--+--+
|M |H |M |
+--+--+--+
|/ |  |M |
+--+--+--+
Input options: <w/a/s/d> - move, <i> - show inventory, <m> - map, <h> - hero stats, <t> - trade, <c> - change inventory, <p> - drink potion, <q> - back to menu, <q> - Exit
t
========MARKET========
What item do you want to buy?
Please select an option:
1. <Item>
	name: Breath_of_Fire
	price: 350
	required_level: 1
	type: FireSpells
</Item>
<Additional Data>
	damage: 450
	mana_cost: 100
</Additional Data>
2. <Item>
	name: Spark_Needles
	price: 500
	required_level: 2
	type: LightningSpells
</Item>
<Additional Data>
	damage: 600
	mana_cost: 200
</Additional Data>
3. <Item>
	name: Mermaid_Tears
	price: 850
	required_level: 5
	type: Potions
</Item>
<Additional Data>
	attribute_affected: Health/Mana/Strength/Agility
	attribute_increase: 100
</Additional Data>
4. <Item>
	name: Wizard_Shield
	price: 1200
	required_level: 10
	type: Armory
</Item>
<Additional Data>
	damage_reduction: 1500
</Additional Data>
5. <Item>
	name: TSwords
	price: 1400
	required_level: 8
	type: Weaponry
</Item>
<Additional Data>
	damage: 1600
	required_hands: 2
</Additional Data>
<1~9> - <Select this item>, <0> - <Cancel and return>
Enter the number of your choice: 0
You decided not to make a selection.
========LEAVE MARKET========
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
|X |M |/ |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |/ |  |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |/ |  |M |H |M |X |
+--+--+--+--+--+--+--+
|X |/ |/ |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |M |  |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
Detailed View:
+--+--+--+
|/ |  |M |
+--+--+--+
|M |H |M |
+--+--+--+
|/ |  |M |
+--+--+--+
Input options: <w/a/s/d> - move, <i> - show inventory, <m> - map, <h> - hero stats, <t> - trade, <c> - change inventory, <p> - drink potion, <q> - back to menu, <q> - Exit
c
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
|X |M |/ |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |/ |  |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |/ |  |M |H |M |X |
+--+--+--+--+--+--+--+
|X |/ |/ |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |M |  |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
Detailed View:
+--+--+--+
|/ |  |M |
+--+--+--+
|M |H |M |
+--+--+--+
|/ |  |M |
+--+--+--+
Input options: <w/a/s/d> - move, <i> - show inventory, <m> - map, <h> - hero stats, <t> - trade, <c> - change inventory, <p> - drink potion, <q> - back to menu, <q> - Exit
i
Now showing inventory of hero 1
<Item>
	name: Axe
	price: 550
	required_level: 5
	type: Weaponry
</Item>
<Additional Data>
	damage: 850
	required_hands: 1
</Additional Data>
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
|X |M |/ |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |/ |  |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |/ |  |M |H |M |X |
+--+--+--+--+--+--+--+
|X |/ |/ |/ |  |M |X |
+--+--+--+--+--+--+--+
|X |M |  |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
Detailed View:
+--+--+--+
|/ |  |M |
+--+--+--+
|M |H |M |
+--+--+--+
|/ |  |M |
+--+--+--+
Input options: <w/a/s/d> - move, <i> - show inventory, <m> - map, <h> - hero stats, <t> - trade, <c> - change inventory, <p> - drink potion, <q> - back to menu, <q> - Exit
s
battle start!
Round 1 begins!

Now is the turn of Hero No.2: Caliber_Heist
This is hero's turn. The hero is: 
hero name: Caliber_Heist
<Hero>
<Attribute>
	Health==100
	Mana==400
	Strength==400
	Agility==400
	Dexterity==400
	Defense==0
</Attribute>
level: character.Level@1ee733d
type: Paladins
</Hero>

Input options: <a> - Basic Attack, <s> - Cast a Spell, <p> - Use a Potion, <h> - Show Heroes Status, <m> - Show Monsters Status, <i> - Show Inventory, <q> - Exit
a
Please select an option:
1. <Monster>
<Attribute>
	Health==100
	Damage==100
	Defense==200
	DodgeChance==10
</Attribute>
level: 1
type: Dragon
</Monster>

2. <Monster>
<Attribute>
	Health==100
	Damage==150
	Defense==250
	DodgeChance==15
</Attribute>
level: 1
type: Exoskeletons
</Monster>

<1~9> - <Select this item>, <0> - <Cancel and return>
Enter the number of your choice: 1
The weapon attack is 0
The hero strength is 400
==> The basic damage is 20
Caliber_Heist deals 20 damage to Natsunomeryu

Now is the turn of Hero No.1: Undefeated_Yoj
This is hero's turn. The hero is: 
hero name: Undefeated_Yoj
<Hero>
<Attribute>
	Health==100
	Mana==400
	Strength==800
	Agility==400
	Dexterity==700
	Defense==0
</Attribute>
level: character.Level@7b84de
type: Warriors
</Hero>

Input options: <a> - Basic Attack, <s> - Cast a Spell, <p> - Use a Potion, <h> - Show Heroes Status, <m> - Show Monsters Status, <i> - Show Inventory, <q> - Exit
a
Please select an option:
1. <Monster>
<Attribute>
	Health==100-20
	Damage==100
	Defense==200
	DodgeChance==10
</Attribute>
level: 1
type: Dragon
</Monster>

2. <Monster>
<Attribute>
	Health==100
	Damage==150
	Defense==250
	DodgeChance==15
</Attribute>
level: 1
type: Exoskeletons
</Monster>

<1~9> - <Select this item>, <0> - <Cancel and return>
Enter the number of your choice: 2
The weapon attack is 0
The hero strength is 800
==> The basic damage is 40
Undefeated_Yoj deals 40 damage to BigBad-Wolf

Now is the turn of Monster No.2: BigBad-Wolf
This is monster's turn. The monster is:
monster name: BigBad-Wolf
<Monster>
<Attribute>
	Health==100-40
	Damage==150
	Defense==250
	DodgeChance==15
</Attribute>
level: 1
type: Exoskeletons
</Monster>

The monster damage is 150
BigBad-Wolf deals 150 damage to Undefeated_Yoj
hero die: Undefeated_Yoj

Now is the turn of Monster No.1: Natsunomeryu
This is monster's turn. The monster is:
monster name: Natsunomeryu
<Monster>
<Attribute>
	Health==100-20
	Damage==100
	Defense==200
	DodgeChance==10
</Attribute>
level: 1
type: Dragon
</Monster>

The monster damage is 100
Natsunomeryu deals 100 damage to Caliber_Heist
hero die: Caliber_Heist
Your team loses the battle!
==========MAIN MENU==========
Input options: <1> - New Game, <2> - Resume Game, <q> - Exit
=============================
1
You started a new game!
Please input the number of rows: (5~10):? Enter your input: 5
Please input the number of columns: (5~10):? Enter your input: 5
Please input the number of heroes: (1~4):? Enter your input: 2
<Hero>
<Attribute>
	Health==100
	Mana==250
	Strength==650
	Agility==600
	Dexterity==350
	Defense==0
</Attribute>
level: character.Level@d46ca6
type: Paladins
</Hero>

<Hero>
<Attribute>
	Health==100
	Mana==1300
	Strength==750
	Agility==450
	Dexterity==500
	Defense==0
</Attribute>
level: character.Level@117d9a3
type: Sorcerers
</Hero>

A new grid has been successfully initialized!
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
|X |/ |/ |/ |  |H |X |
+--+--+--+--+--+--+--+
|X |M |/ |M |  |  |X |
+--+--+--+--+--+--+--+
|X |  |  |  |  |M |X |
+--+--+--+--+--+--+--+
|X |/ |  |  |/ |  |X |
+--+--+--+--+--+--+--+
|X |  |  |  |  |M |X |
+--+--+--+--+--+--+--+
|X |X |X |X |X |X |X |
+--+--+--+--+--+--+--+
Detailed View:
+--+--+--+
|X |X |X |
+--+--+--+
|  |H |X |
+--+--+--+
|  |  |X |
+--+--+--+
Input options: <w/a/s/d> - move, <i> - show inventory, <m> - map, <h> - hero stats, <t> - trade, <c> - change inventory, <p> - drink potion, <q> - back to menu, <q> - Exit
q
Good bye~
```




