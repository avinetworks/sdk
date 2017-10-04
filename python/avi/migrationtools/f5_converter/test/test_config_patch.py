'''
Created on Mar 31, 2015

@author: Gaurav Rastogi (grastogi@avinetworks.com)
Copyright Avi Networks Inc. 2017
'''
import json
import unittest
import yaml
from avi.migrationtools.config_patch import ConfigPatch


class Test(unittest.TestCase):
    def setUp(self):
        # load avi config
        with open('avi_config.json') as f:
            self.acfg = json.load(f)

        with open('patch.yaml') as f:
            self.patches = yaml.load(f)

    def tearDown(self):
        pass

    def testBasicRun(self):
        cp = ConfigPatch(self.acfg, self.patches)
        patched_cfg = cp.patch()
        assert patched_cfg

        pools = patched_cfg.get('Pool')
        patched_pool = [pool for pool in pools if pool['name'] == 'coolpool']
        assert patched_pool

        vs = [vs for vs in patched_cfg.get('VirtualService') if vs['name'] == 'vs1']
        assert vs
        print json.dumps(vs, indent=2)
        assert vs[0]['pool_ref'] == '/api/pool/?tenant=admin&name=coolpool&cloud=AWS'
        cicd_pools = [pool for pool in pools if pool['name'].find('cicd') != -1]
        for p in cicd_pools:
            assert p['enabled'] is False
            assert p['tenant_ref'] == '/api/tenant/?name=awesome'

    def testArraySubstitution(self):
        patches = {
            'Pool': [
                {
                    'match_name': 'p1',
                    'patch': {
                        'servers': []
                    }
                }
            ]
        }
        cp = ConfigPatch(self.acfg, patches)
        patched_cfg = cp.patch()
        pools = patched_cfg.get('Pool')
        patched_pool = [pool for pool in pools if pool['name'] == 'p1']
        assert patched_pool
        assert not patched_pool[0]['servers']

