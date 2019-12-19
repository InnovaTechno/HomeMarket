Group Project - CodePath
===

# HOMEMARKET

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Market at Home is an app that shows the nearby Markets, their daily products, all the informations about them, and allow you to buy them and get a delivery.

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** Shopping
- **Mobile:** mobile is essential for the users to login everywhere and at anytime.
- **Story:** allow users to see all informations about selected supermarkets, including products and services. users will also be able to buy products online, compare prices and get a delivery.
- **Market:** anyone with an online method of payment can use this app. 
- **Habit:** This app could be used as often as the user wanted. User can verify available services and products of their surrounded markets many times a day. Users can learn more about available products with their respective price. User will know markets'trading hours, services like if the market have money fastfood or a café, money transfer services, atm, drugstore, etc...

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**
- [x] user can create an account and login
- [x] user can see all categories of items
- [x] user can see the new products available on the app
- [x] user can browse products
- [x] user can see a list of markets
- [x] user can select a market to see list a detailed page to see all the informations about the selected market
- [x] user can select a product to see details about it
- [x] user can select a product to see the related items
- [ ] user can add products to cart and then process a payment to buy it
- [ ] user can receive notifications with a confirmation code.

**Optional Nice-to-have Stories**

- [ ] user can ask for a delivery
- [ ] user can have multiple methods of online payment
- [ ] user can have on-time pictures of products
- [X] user can select a product and see a list of similar items
- [ ] user can rate market and services
- [ ] user can add reviews about markets and the app
- [ ] user can see market nearby depending of his location 


### 2. Screen Archetypes

* Welcome screen
* Browse products (New products and By categories) 
* Select a product and see every details about it.
* Add to favorites 
* Add to cart
* Register - User signs up with a social account or logs into their account 
* Login
* Payment 
* Select a market, and see every details about it(location and offered services)
### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home
* Favourites
* Cart
* Profile
Optional:
* Delivery

**Flow Navigation** (Screen to Screen)
* Welcome screen reen 
* List of products
* List of markets 
* Cart screen 
* Forced Log-in -> Account creation if no log in is available



## Wireframes
[Add picture of your hand sketched wireframes in this section]


### [BONUS] Digital Wireframes & Mockups
<img src="https://imgur.com/jvXnnkO.jpg" height=200>
 
### [BONUS] Interactive Prototype
https://www.figma.com/file/cuvx51VCAIDak9bQvivNBt/HOMEMARKET?node-id=0%3A1




## Schema 
### Models
#### Post (Fruits & legumes, Viandes, Produits Laitiers, Boissons, Pains, Chips & Sucreries, Boissons Alcolisees, Produits Cosmetiques, Articles Menagers)
 
   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | image         | File     | image that app managers post |
   | name          | String   | name of products |
   | price         | String   | price of products |
   | description   | String   | description of every products |
   | devise        | String   | devise and quantity |
   | createdAt     | DateTime | date when post is created (default field) |
   | updatedAt     | DateTime | date when post is last updated (default field) |

#### NewProducts
 
   | Property       | Type      | Description |
   | -------------  | --------  | ------------|
   | newProductImage| File     | image that app managers post |
   | name           | String   | name of products |
   | createdAt      | DateTime | date when post is created (default field) |
   | updatedAt      | DateTime | date when post is last updated (default field) |

#### MarketDetails
 
   | Property       | Type      | Description |
   | -------------  | --------  | ------------|
   | description    | String    | description of the market |
   | adresse        | String    | adress of the market |
   | telephone      | Number    | phone number of the market |
   | services       | String    | services offer by the market |
   | createdAt      | DateTime  | date when post is created (default field) |
   | updatedAt      | DateTime  | date when post is last updated (default field) |
   
#### Related Items
 
   | Property       | Type      | Description |
   | -------------  | --------  | ------------|
   | name           | String    | name of the products |
   | price          | String    | the price of the products |
   | image          |File       | image that app managers post |
   | devise         | String    | devise |
   | createdAt      | DateTime  | date when post is created (default field) |
   | updatedAt      | DateTime  | date when post is last updated (default field) |
   
#### User
   | Property            | Type     | Description |
   | -------------       | -------- | ------------|
   | ProfileImage        | File     | Profile image of the user |
   | Name                | String   | name of the user |
   | Username            | String   | username of the user |
   | Password            | String   | password of the user |
   | Email               | String   |  email of the user |
   | Phone	              | number   | The phone number of the user |
   | Alternative contact | number   | Phone number of the Alternative person |
   | Adress              | String   | Adress of the user|
   | createdAt           | DateTime | date when post is created (default field) |
   | updatedAt           | DateTime | date when post is last updated (default field) |
   
   
### Networking
#### List of network requests by screen
   - Products Screen
      - (Read/GET) Query all products post by the app managers 

   - New Products Screen
      - (Read/GET) Query all the new products post by the app managers
      
   - Product Details Screen
      - (Read/GET) Query all the new products post by the app managers
      
   - Sign up Screen 
      - (Create/POST) Create a new user 
      - (Read/GET) Query log in user

   - Sign in Screen 
      - (Read/GET) Query log in new user

   - Market Details Screen
      - (Read/GET) Query all the deatils post by the app managers

   - Cart Screen 
      - (Create/POST) Create a new order
      - (Read/GET) Return confirmation code to the user 
      

