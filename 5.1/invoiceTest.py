import json
import unittest
from assertpy import *
import invoice


class InvoiceTest(unittest.TestCase):
    def setUp(self):
        invoice_f = open('invoice.json')
        plays_f = open('plays.json')
        self.invoice_data = json.load(invoice_f)
        self.plays_data = json.load(plays_f)
        invoice_f.close()
        plays_f.close()

    def test_statement_returns_values(self):
        assert_that(invoice.statement(self.invoice_data, self.plays_data)).is_not_none()

    def test_contains_price(self):
        assert_that(invoice.statement(self.invoice_data, self.plays_data)).contains('Othello: $500.00 (40 seats)')

    def test_view_amount_of_credits(self):
        credits_regexp = r'Amount owed is \d*'
        assert_that(invoice.statement(self.invoice_data, self.plays_data)).matches(credits_regexp)

    def test_hamlet(self):
        assert_that(invoice.statement(self.invoice_data, self.plays_data)).contains("Hamlet:")

    def test_no_macbeth(self):
        assert_that(invoice.statement(self.invoice_data, self.plays_data)).does_not_contain("Sport:")

    def test_raises_value_error(self):
        wrong_play = {
            "hamlet": {"name": "Hamlet", "type": "sport"},
        }
        assert_that(invoice.statement).raises(ValueError).when_called_with(self.invoice_data, wrong_play)