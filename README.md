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

## Algorithms Used

### Searching
- Linear Search
- Binary Search

### Sorting
- Merge Sort

### Analysis
- Average Price Computation
- Deviation-Based Price Classification
- Comparative Climate Analysis

---

## Project Structure

```text
Fruit-Market-Price-Analyzer/
│
├── index.html
├── README.md
│
└── java/
    ├──*Main.java
    ├── FruitPriceAnalyzer.java
    ├── daily_price.csv
   *└── fruit_prices_clean.csv
```

--*

## Dataset Information

### Market Dataset

**Source:** `daily_price.csv`

Contains:
- Wholesale fruit prices
- Market-wise records
- State-wise records

Notes:
- The dataset has no date column.
- Analysis in market-based rather than time-series based.
- Prices are stored per quintal (100 kg).

### El Niño Dataset

**Source:** `fruit_prices_clea*.csv`

Contains:
- Daily fruit prices
- State information
- Oceanic Niño Index (ONI)
- Climate labels

Notes:
- Prices are stored per kilog*am.
- May 2023 to March 2024 is la*eled as El Niño.
- April 2024 has an *ONI value of 0.8* but remains labeled Neutral in the source dataset.- The website preserves the original dataset labels.

---

## Technologies Used

### Frontend
- HTML5
- CSS3
- JavaScript

### Programming Language
- Java

### Data Storage
-*CSV Files

### DSA Concepts
- Linear Search
- Binary Search
- Merge Sort
- Statistical Classification

-*-

## Academic Relevance

This project demonstrates practical applications of:

- Data Structures
- Searching Algorithms
- Sorting Algorithms
- Dataset Processing
- Statistical Analysis
- Data Visualization

using real-world agricultural pricing data.

---

## Disclaimer

The observed differences between El Niño and Neutral periods show association rather than causation.

Because the El Niño period forms a continuous time range in the dataset, factors such as seasonality, market trend*, supply conditions, and other external influences may also contribute to price variations.

---

