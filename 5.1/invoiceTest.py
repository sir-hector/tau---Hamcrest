import json
import unittest
from assertpy import *
import invoice


class InvoiceTest(unittest.TestCase):
    def setUp(self):
        invoice_f = open('invoice.json')
        plays_f = open('plays.json')
        invoice_data = json.load(invoice_f)
        plays_data = json.load(plays_f)
        invoice_f.close()
        plays_f.close()
        self.temp = invoice.statement(invoice_data, plays_data)

    def testStatement(self):
        assert_that(self.temp).contains('Othello: $500.00 (40 seats)')


    def tearDown(self):
        self.temp = None
