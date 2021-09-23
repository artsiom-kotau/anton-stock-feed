package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.ReportEntity;

import java.util.ArrayList;
import java.util.Collection;

public class APIServiceMock implements APIService {
    CompanyProfileService companyProfileService;
    JsonSerialize jsonSerialize;

    public APIServiceMock(CompanyProfileService companyProfileService, JsonSerialize jsonSerialize) {
        this.companyProfileService = companyProfileService;
        this.jsonSerialize = jsonSerialize;
    }

    @Override
    public void getCompanyProfile() {
        // Default data
        String data = "[{\"currency\":\"USD\",\"description\":\"MICROSOFT CORP\",\"displaySymbol\":\"MSFT\",\"figi\":\"BBG000BPH459\",\"mic\":\"XNAS\",\"symbol\":\"MSFT\",\"type\":\"Common Stock\"}," +
                "{\"currency\":\"USD\",\"description\":\"APPLE INC\",\"displaySymbol\":\"AAPL\",\"figi\":\"BBG000B9XRY4\",\"mic\":\"XNAS\",\"symbol\":\"AAPL\",\"type\":\"Common stock\"}]";

//        // Update data
//        String data = "[{\"currency\":\"USD\",\"description\":\"123\",\"displaySymbol\":\"123\",\"figi\":\"123\",\"mic\":\"123\",\"symbol\":\"TSLA\",\"type\":\"123\"}," +
//                "{\"currency\":\"USD\",\"description\":\"321\",\"displaySymbol\":\"321\",\"figi\":\"321\",\"mic\":\"321\",\"symbol\":\"AAPL\",\"type\":\"321\"}]";

//        // Delete data
//        String data = "[{\"currency\":\"USD\",\"description\":\"TESLA INC\",\"displaySymbol\":\"TSLA\",\"figi\":\"BBG000N9MNX3\",\"mic\":\"XNAS\",\"symbol\":\"TSLA\",\"type\":\"Common Stock\"}]";

//        // Insert data
//        String data = "[{\"currency\":\"USD\",\"description\":\"MICROSOFT CORP\",\"displaySymbol\":\"MSFT\",\"figi\":\"BBG000BPH459\",\"mic\":\"XNAS\",\"symbol\":\"MSFT\",\"type\":\"Common Stock\"}," +
//                "{\"currency\":\"USD\",\"description\":\"APPLE INC\",\"displaySymbol\":\"AAPL\",\"figi\":\"BBG000B9XRY4\",\"mic\":\"XNAS\",\"symbol\":\"AAPL\",\"type\":\"Common stock\"}," +
//                "{\"currency\":\"USD\",\"description\":\"TESLA INC\",\"displaySymbol\":\"TSLA\",\"figi\":\"BBG000N9MNX3\",\"mic\":\"XNAS\",\"symbol\":\"TSLA\",\"type\":\"Common Stock\"}]";

        Collection<CompanyDto> companies = jsonSerialize.deserializeToCollection(data, CompanyDto.class);
        companyProfileService.writeData(companies);
    }

    @Override
    public void getReport() {
        // 1 report
        String reportApple2020 = "{\n" +
                "\"cik\": \"320193\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"accessNumber\": \"0000320193-20-000096\",\n" +
                "            \"symbol\": \"AAPL\",\n" +
                "            \"cik\": \"320193\",\n" +
                "            \"year\": 2020,\n" +
                "            \"quarter\": 0,\n" +
                "            \"form\": \"10-K\",\n" +
                "            \"startDate\": \"2019-09-29 00:00:00\",\n" +
                "            \"endDate\": \"2020-09-26 00:00:00\",\n" +
                "            \"filedDate\": \"2020-10-30 00:00:00\",\n" +
                "            \"acceptedDate\": \"2020-10-29 18:06:25\",\n" +
                "            \"report\": {\n" +
                "                \"bs\": [\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Cash and cash equivalents\",\n" +
                "                        \"value\": 38016000000,\n" +
                "                        \"concept\": \"CashAndCashEquivalentsAtCarryingValue\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Marketable securities\",\n" +
                "                        \"value\": 52927000000,\n" +
                "                        \"concept\": \"MarketableSecuritiesCurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Accounts receivable, net\",\n" +
                "                        \"value\": 16120000000,\n" +
                "                        \"concept\": \"AccountsReceivableNetCurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Inventories\",\n" +
                "                        \"value\": 4061000000,\n" +
                "                        \"concept\": \"InventoryNet\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Vendor non-trade receivables\",\n" +
                "                        \"value\": 21325000000,\n" +
                "                        \"concept\": \"NontradeReceivablesCurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Other current assets\",\n" +
                "                        \"value\": 11264000000,\n" +
                "                        \"concept\": \"OtherAssetsCurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Current assets:\",\n" +
                "                        \"value\": 143713000000,\n" +
                "                        \"concept\": \"AssetsCurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Marketable securities\",\n" +
                "                        \"value\": 100887000000,\n" +
                "                        \"concept\": \"MarketableSecuritiesNoncurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Property, plant and equipment, net\",\n" +
                "                        \"value\": 36766000000,\n" +
                "                        \"concept\": \"PropertyPlantAndEquipmentNet\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Other non-current assets\",\n" +
                "                        \"value\": 42522000000,\n" +
                "                        \"concept\": \"OtherAssetsNoncurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Total non-current assets\",\n" +
                "                        \"value\": 180175000000,\n" +
                "                        \"concept\": \"AssetsNoncurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"ASSETS:\",\n" +
                "                        \"value\": 323888000000,\n" +
                "                        \"concept\": \"Assets\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Accounts payable\",\n" +
                "                        \"value\": 42296000000,\n" +
                "                        \"concept\": \"AccountsPayableCurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Other current liabilities\",\n" +
                "                        \"value\": 42684000000,\n" +
                "                        \"concept\": \"OtherLiabilitiesCurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Deferred revenue\",\n" +
                "                        \"value\": 6643000000,\n" +
                "                        \"concept\": \"ContractWithCustomerLiabilityCurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Commercial paper\",\n" +
                "                        \"value\": 4996000000,\n" +
                "                        \"concept\": \"CommercialPaper\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Term debt\",\n" +
                "                        \"value\": 8773000000,\n" +
                "                        \"concept\": \"LongTermDebtCurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Total current liabilities\",\n" +
                "                        \"value\": 105392000000,\n" +
                "                        \"concept\": \"LiabilitiesCurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Term debt\",\n" +
                "                        \"value\": 98667000000,\n" +
                "                        \"concept\": \"LongTermDebtNoncurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Other non-current liabilities\",\n" +
                "                        \"value\": 54490000000,\n" +
                "                        \"concept\": \"OtherLiabilitiesNoncurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Total non-current liabilities\",\n" +
                "                        \"value\": 153157000000,\n" +
                "                        \"concept\": \"LiabilitiesNoncurrent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"LIABILITIES AND SHAREHOLDERSu2019 EQUITY:\",\n" +
                "                        \"value\": 258549000000,\n" +
                "                        \"concept\": \"Liabilities\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Commitments and Contingencies\",\n" +
                "                        \"value\": \"N/A\",\n" +
                "                        \"concept\": \"CommitmentsAndContingencies\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Common stock and additional paid-in capital, $0.00001 par value: 50,400,000 shares authorized; 16,976,763 and 17,772,945 shares issued and outstanding, respectively\",\n" +
                "                        \"value\": 50779000000,\n" +
                "                        \"concept\": \"CommonStocksIncludingAdditionalPaidInCapital\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Retained earnings\",\n" +
                "                        \"value\": 14966000000,\n" +
                "                        \"concept\": \"RetainedEarningsAccumulatedDeficit\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Accumulated other comprehensive income/(loss)\",\n" +
                "                        \"value\": -406000000,\n" +
                "                        \"concept\": \"AccumulatedOtherComprehensiveIncomeLossNetOfTax\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Common stock split ratio\",\n" +
                "                        \"value\": 65339000000,\n" +
                "                        \"concept\": \"StockholdersEquity\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"LIABILITIES AND SHAREHOLDERSu2019 EQUITY:\",\n" +
                "                        \"value\": 323888000000,\n" +
                "                        \"concept\": \"LiabilitiesAndStockholdersEquity\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"cf\": [\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Numerator:\",\n" +
                "                        \"value\": 57411000000,\n" +
                "                        \"concept\": \"NetIncomeLoss\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Depreciation and amortization\",\n" +
                "                        \"value\": 11056000000,\n" +
                "                        \"concept\": \"DepreciationDepletionAndAmortization\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"RSUs granted (in shares)\",\n" +
                "                        \"value\": 6829000000,\n" +
                "                        \"concept\": \"ShareBasedCompensation\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Deferred income tax benefit\",\n" +
                "                        \"value\": -215000000,\n" +
                "                        \"concept\": \"DeferredIncomeTaxExpenseBenefit\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Other\",\n" +
                "                        \"value\": 97000000,\n" +
                "                        \"concept\": \"OtherNoncashIncomeExpense\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Accounts receivable, net\",\n" +
                "                        \"value\": -6917000000,\n" +
                "                        \"concept\": \"IncreaseDecreaseInAccountsReceivable\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Inventories\",\n" +
                "                        \"value\": 127000000,\n" +
                "                        \"concept\": \"IncreaseDecreaseInInventories\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Vendor non-trade receivables\",\n" +
                "                        \"value\": -1553000000,\n" +
                "                        \"concept\": \"IncreaseDecreaseInOtherReceivables\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Other current and non-current assets\",\n" +
                "                        \"value\": 9588000000,\n" +
                "                        \"concept\": \"IncreaseDecreaseInOtherOperatingAssets\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Accounts payable\",\n" +
                "                        \"value\": -4062000000,\n" +
                "                        \"concept\": \"IncreaseDecreaseInAccountsPayable\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Deferred revenue\",\n" +
                "                        \"value\": 2081000000,\n" +
                "                        \"concept\": \"IncreaseDecreaseInContractWithCustomerLiability\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Other current and non-current liabilities\",\n" +
                "                        \"value\": 8916000000,\n" +
                "                        \"concept\": \"IncreaseDecreaseInOtherOperatingLiabilities\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Cash generated by operating activities\",\n" +
                "                        \"value\": 80674000000,\n" +
                "                        \"concept\": \"NetCashProvidedByUsedInOperatingActivities\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Purchases of marketable securities\",\n" +
                "                        \"value\": 114938000000,\n" +
                "                        \"concept\": \"PaymentsToAcquireAvailableForSaleSecuritiesDebt\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Proceeds from maturities of marketable securities\",\n" +
                "                        \"value\": 69918000000,\n" +
                "                        \"concept\": \"ProceedsFromMaturitiesPrepaymentsAndCallsOfAvailableForSaleSecurities\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Proceeds from sales of marketable securities\",\n" +
                "                        \"value\": 50473000000,\n" +
                "                        \"concept\": \"ProceedsFromSaleOfAvailableForSaleSecuritiesDebt\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Payments for acquisition of property, plant and equipment\",\n" +
                "                        \"value\": 7309000000,\n" +
                "                        \"concept\": \"PaymentsToAcquirePropertyPlantAndEquipment\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Payments made in connection with business acquisitions, net\",\n" +
                "                        \"value\": 1524000000,\n" +
                "                        \"concept\": \"PaymentsToAcquireBusinessesNetOfCashAcquired\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Purchases of non-marketable securities\",\n" +
                "                        \"value\": 210000000,\n" +
                "                        \"concept\": \"PaymentsToAcquireOtherInvestments\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Proceeds from non-marketable securities\",\n" +
                "                        \"value\": 92000000,\n" +
                "                        \"concept\": \"ProceedsFromSaleAndMaturityOfOtherInvestments\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Other\",\n" +
                "                        \"value\": 791000000,\n" +
                "                        \"concept\": \"PaymentsForProceedsFromOtherInvestingActivities\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Investing activities:\",\n" +
                "                        \"value\": -4289000000,\n" +
                "                        \"concept\": \"NetCashProvidedByUsedInInvestingActivities\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Proceeds from issuance of common stock\",\n" +
                "                        \"value\": 880000000,\n" +
                "                        \"concept\": \"ProceedsFromIssuanceOfCommonStock\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Payments for taxes related to net share settlement of equity awards\",\n" +
                "                        \"value\": 3634000000,\n" +
                "                        \"concept\": \"PaymentsRelatedToTaxWithholdingForShareBasedCompensation\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Payments for dividends and dividend equivalents\",\n" +
                "                        \"value\": 14081000000,\n" +
                "                        \"concept\": \"PaymentsOfDividends\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Repurchases of common stock\",\n" +
                "                        \"value\": 72358000000,\n" +
                "                        \"concept\": \"PaymentsForRepurchaseOfCommonStock\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Proceeds from issuance of term debt, net\",\n" +
                "                        \"value\": 16091000000,\n" +
                "                        \"concept\": \"ProceedsFromIssuanceOfLongTermDebt\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Repayments of term debt\",\n" +
                "                        \"value\": 12629000000,\n" +
                "                        \"concept\": \"RepaymentsOfLongTermDebt\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Repayments of commercial paper, net\",\n" +
                "                        \"value\": -963000000,\n" +
                "                        \"concept\": \"ProceedsFromRepaymentsOfCommercialPaper\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Other\",\n" +
                "                        \"value\": -126000000,\n" +
                "                        \"concept\": \"ProceedsFromPaymentsForOtherFinancingActivities\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Cash used in financing activities\",\n" +
                "                        \"value\": -86820000000,\n" +
                "                        \"concept\": \"NetCashProvidedByUsedInFinancingActivities\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Increase/(Decrease) in cash, cash equivalents and restricted cash\",\n" +
                "                        \"value\": -10435000000,\n" +
                "                        \"concept\": \"CashCashEquivalentsRestrictedCashAndRestrictedCashEquivalentsPeriodIncreaseDecreaseIncludingExchangeRateEffect\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Cash paid for income taxes, net\",\n" +
                "                        \"value\": 9501000000,\n" +
                "                        \"concept\": \"IncomeTaxesPaidNet\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Cash paid for interest\",\n" +
                "                        \"value\": 3002000000,\n" +
                "                        \"concept\": \"InterestPaidNet\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"ic\": [\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Net sales\",\n" +
                "                        \"value\": 274515000000,\n" +
                "                        \"concept\": \"RevenueFromContractWithCustomerExcludingAssessedTax\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Cost of sales\",\n" +
                "                        \"value\": 169559000000,\n" +
                "                        \"concept\": \"CostOfGoodsAndServicesSold\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Gross margin\",\n" +
                "                        \"value\": 104956000000,\n" +
                "                        \"concept\": \"GrossProfit\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Research and development\",\n" +
                "                        \"value\": 18752000000,\n" +
                "                        \"concept\": \"ResearchAndDevelopmentExpense\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Selling, general and administrative\",\n" +
                "                        \"value\": 19916000000,\n" +
                "                        \"concept\": \"SellingGeneralAndAdministrativeExpense\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Total operating expenses\",\n" +
                "                        \"value\": 38668000000,\n" +
                "                        \"concept\": \"OperatingExpenses\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Operating income\",\n" +
                "                        \"value\": 66288000000,\n" +
                "                        \"concept\": \"OperatingIncomeLoss\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"OI&E\",\n" +
                "                        \"value\": 803000000,\n" +
                "                        \"concept\": \"NonoperatingIncomeExpense\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Income before provision for income taxes\",\n" +
                "                        \"value\": 67091000000,\n" +
                "                        \"concept\": \"IncomeLossFromContinuingOperationsBeforeIncomeTaxesExtraordinaryItemsNoncontrollingInterest\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Provision for income taxes\",\n" +
                "                        \"value\": 9680000000,\n" +
                "                        \"concept\": \"IncomeTaxExpenseBenefit\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Numerator:\",\n" +
                "                        \"value\": 57411000000,\n" +
                "                        \"concept\": \"NetIncomeLoss\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd/shares\",\n" +
                "                        \"label\": \"Basic (in dollars per share)\",\n" +
                "                        \"value\": 3.31,\n" +
                "                        \"concept\": \"EarningsPerShareBasic\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd/shares\",\n" +
                "                        \"label\": \"Diluted (in dollars per share)\",\n" +
                "                        \"value\": 3.28,\n" +
                "                        \"concept\": \"EarningsPerShareDiluted\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"shares\",\n" +
                "                        \"label\": \"Basic (in shares)\",\n" +
                "                        \"value\": 17352119000,\n" +
                "                        \"concept\": \"WeightedAverageNumberOfSharesOutstandingBasic\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"shares\",\n" +
                "                        \"label\": \"Diluted (in shares)\",\n" +
                "                        \"value\": 17528214000,\n" +
                "                        \"concept\": \"WeightedAverageNumberOfDilutedSharesOutstanding\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Change in foreign currency translation, net of tax\",\n" +
                "                        \"value\": 88000000,\n" +
                "                        \"concept\": \"OtherComprehensiveIncomeLossForeignCurrencyTransactionAndTranslationAdjustmentNetOfTax\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Change in fair value of derivatives\",\n" +
                "                        \"value\": 79000000,\n" +
                "                        \"concept\": \"aapl:OtherComprehensiveIncomeLossDerivativeInstrumentGainLossbeforeReclassificationafterTax\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Adjustment for net (gains)/losses realized and included in net income\",\n" +
                "                        \"value\": 1264000000,\n" +
                "                        \"concept\": \"OtherComprehensiveIncomeLossCashFlowHedgeGainLossReclassificationAfterTax\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Total change in unrealized gains/losses on derivative instruments\",\n" +
                "                        \"value\": -1185000000,\n" +
                "                        \"concept\": \"aapl:OtherComprehensiveIncomeLossDerivativeInstrumentGainLossafterReclassificationandTax\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Change in fair value of marketable debt securities\",\n" +
                "                        \"value\": 1202000000,\n" +
                "                        \"concept\": \"OtherComprehensiveIncomeUnrealizedHoldingGainLossOnSecuritiesArisingDuringPeriodNetOfTax\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Adjustment for net (gains)/losses realized and included in net income\",\n" +
                "                        \"value\": 63000000,\n" +
                "                        \"concept\": \"OtherComprehensiveIncomeLossReclassificationAdjustmentFromAOCIForSaleOfSecuritiesNetOfTax\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Total change in unrealized gains/losses on marketable debt securities\",\n" +
                "                        \"value\": 1139000000,\n" +
                "                        \"concept\": \"OtherComprehensiveIncomeLossAvailableForSaleSecuritiesAdjustmentNetOfTax\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Total other comprehensive income/(loss)\",\n" +
                "                        \"value\": 42000000,\n" +
                "                        \"concept\": \"OtherComprehensiveIncomeLossNetOfTaxPortionAttributableToParent\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"unit\": \"usd\",\n" +
                "                        \"label\": \"Other comprehensive income/(loss):\",\n" +
                "                        \"value\": 57453000000,\n" +
                "                        \"concept\": \"ComprehensiveIncomeNetOfTax\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        }\n" +
                "],\n" +
                "    \"symbol\": \"AAPL\"\n" +
                "}";





        ArrayList<ReportEntity> reports = (ArrayList<ReportEntity>) jsonSerialize.deserializeToCollection(reportApple2020, ReportEntity.class);
        System.out.println(reports.get(0));








    }

    public void run() {
        getCompanyProfile();
    }
}
