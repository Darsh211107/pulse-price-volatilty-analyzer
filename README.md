# Fruit Market Price Analyzer

An academic Data Structures and Algorithms (DSA) project that analyzes wholesale fruit prices in India and explores their relationship with El Niño climate conditions.

The project includes:

- A web-based dashboard for interactive exploration of fruit price data
- Java console applications demonstrating searching, sorting, and price analysis algorithms
- Real-world datasets containing fruit prices from Indian agricultural markets

---

## Project Overview

Fruit prices can vary significantly due to seasonal patterns, weather conditions, and market factors. This project provides tools to:

- Analyze fruit prices across states and markets
- Detect unusually high or low prices using deviation analysis
- Compare prices during El Niño and Neutral climate periods
- Demonstrate practical DSA concepts using real-world data

---

## Features

### Web Application

The website is fully client-side and works offline.

#### Market Price Analysis

- 5,557 market price records
- 186 commodities
- 856 fruit-specific records
- Commodity, State, and Market filters
- Search functionality
- Sorting functionality
- Price classification system

Price categories:

| Category | Deviation from Average |
|----------|------------------------|
| Normal | ≤ 20% |
| Moderate | > 20% and ≤ 40% |
| Abnormal | > 40% |

#### El Niño Analysis

- 53,827 daily fruit price records
- Data from January 2023 to October 2025
- Oceanic Niño Index (ONI) integration
- El Niño and Neutral classification
- Monthly trend analysis
- Fruit-wise comparisons
- Year-wise comparisons
- Complete dataset table

---

## Running the Website

1. Clone or download the repository.
2. Open `index.html` in any modern browser.
3. Use the Commodity, State, Market, and Search filters to explore the data.
4. Use sorting options to compare prices.

No installation or server setup is required.

---

## Running the Java Applications

Navigate to the Java directory:

```bash
cd java
```

Compile the programs:

```bash
javac *.java
```

Run the Market Price An*lyzer:

```bash
java Main
```

Run*the El Niño Analyzer:

```bash
jav* FruitPriceAnalyzer
```

---

## A*gorithms Used

### Searching
- Lin*ar Search
- Binary Search

### Sor*ing
- Merge Sort

### Analysis
- A*erage Price Computation
- Deviatio*-Based Price Classification
- Comp*rative Climate Analysis

---

## P*oject Structure

```text
Fruit-Mar*et-Price-Analyzer/
│
├── index.htm*
├── README.md
│
└── java/
    ├──*Main.java
    ├── FruitPriceAnalyz*r.java
    ├── daily_price.csv
   *└── fruit_prices_clean.csv
```

--*

## Dataset Information

### Mark*t Dataset

**Source:** `daily_pric*.csv`

Contains:
- Wholesale fruit*prices
- Market-wise records
- Sta*e-wise records

Notes:
- The datas*t has no date column.
- Analysis i* market-based rather than time-ser*es based.
- Prices are stored per *uintal (100 kg).

### El Niño Data*et

**Source:** `fruit_prices_clea*.csv`

Contains:
- Daily fruit pri*es
- State information
- Oceanic N*ño Index (ONI)
- Climate labels

N*tes:
- Prices are stored per kilog*am.
- May 2023 to March 2024 is la*eled as El Niño.
- April 2024 has *n ONI value of 0.8 but remains lab*led Neutral in the source dataset.*- The website preserves the origin*l dataset labels.

---

## Technol*gies Used

### Frontend
- HTML5
- *SS3
- JavaScript

### Programming *anguage
- Java

### Data Storage
-*CSV Files

### DSA Concepts
- Line*r Search
- Binary Search
- Merge S*rt
- Statistical Classification

-*-

## Academic Relevance

This pro*ect demonstrates practical applica*ions of:

- Data Structures
- Sear*hing Algorithms
- Sorting Algorith*s
- Dataset Processing
- Statistic*l Analysis
- Data Visualization

u*ing real-world agricultural pricin* data.

---

## Disclaimer

The ob*erved differences between El Niño *nd Neutral periods show associatio* rather than causation.

Because t*e El Niño period forms a continuou* time range in the dataset, factor* such as seasonality, market trend*, supply conditions, and other ext*rnal influences may also contribut* to price variations.

---

## Aut*or

**Darsh Ved**

Academic projec* developed for learning and demons*rating Data Structures and Algorit*ms through real-world agricultural*data analysis.
