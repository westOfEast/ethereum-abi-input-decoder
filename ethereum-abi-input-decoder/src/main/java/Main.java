/**
 * @Description: 参数解码执行入口
 * @Author: yaachou
 * @Date: 2021/9/9
 * @Version: $
 */

public class Main {
    public static void main(String[] args) {
        NewABIDecoder decoder = new NewABIDecoder();

//        String paramTypes = "bytes, bytes32, uint256";
//        String paramInput = "0x89f92a7c000000000000000000000000000000000000000000000000000000000000006055976cf7cd08f12a1b53ced9752f3fffbc99087ad532efb8daed20111e6472b90000000000000000000000000000000000000000000000000000000000c8dcce000000000000000000000000000000000000000000000000000000000000004116cfb32d184c61570956927048adc74fe187e28d98447f65ff6a2958498c1a32797fa21e2f29c8179a913bdb0e5934fa64847d6bf22ea748763e3bf8c422e6ff1c00000000000000000000000000000000000000000000000000000000000000";

        String paramTypes = "uint8[], uint256[], bytes[]";
        String paramInput = "0x656f3d640000000000000000000000000000000000000000000000000000000000000060000000000000000000000000000000000000000000000000000000000000014000000000000000000000000000000000000000000000000000000000000002200000000000000000000000000000000000000000000000000000000000000006000000000000000000000000000000000000000000000000000000000000000b0000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000001e0000000000000000000000000000000000000000000000000000000000000002000000000000000000000000000000000000000000000000000000000000000400000000000000000000000000000000000000000000000000000000000000150000000000000000000000000000000000000000000000000000000000000006000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000600000000000000000000000000000000000000000000000000000000000000c0000000000000000000000000000000000000000000000000000000000000014000000000000000000000000000000000000000000000000000000000000001a0000000000000000000000000000000000000000000000000000000000000034000000000000000000000000000000000000000000000000000000000000003c000000000000000000000000000000000000000000000000000000000000004200000000000000000000000000000000000000000000000000000000000000060000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000004d658c5317c4b4f8f1c6d000000000000000000000000ff498bbcbf40d0f30f178f553e8fa36153baf30b0000000000000000000000000000000000000000000000000000000000000180000000000000000000000000ff498bbcbf40d0f30f178f553e8fa36153baf30b00000000000000000000000000000000000000000000000000000000000000a000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000a4e343fe12000000000000000000000000a47c8bf37f92abed4a126bda807a7b7498661acd00000000000000000000000099d8a9c45b2eca8864373a26d1459e3dff1e17f3000000000000000000000000fb77650f0aa774220fbffee4677b169b06330878000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004d658c5317c4b4f8f1c6d000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000060000000000000000000000000000000000000000000050f9a9d2ec84eba51c164000000000000000000000000fb77650f0aa774220fbffee4677b169b0633087800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000040000000000000000000000000000000000000000000012623cc469bec120b69bd000000000000000000000000fb77650f0aa774220fbffee4677b169b063308780000000000000000000000000000000000000000000000000000000000000080000000000000000000000000a47c8bf37f92abed4a126bda807a7b7498661acd000000000000000000000000fb77650f0aa774220fbffee4677b169b063308780000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012623cc469bec120b69bd";
//        String paramTypes = "uint32, bool";
//        String paramInput = "0xcdcd77c000000000000000000000000000000000000000000000000000000000000000450000000000000000000000000000000000000000000000000000000000000001";

        String result = decoder.run(paramTypes, paramInput);
        System.out.println(result);
    }
}

//编码文档地址 https://docs.soliditylang.org/en/v0.5.3/abi-spec.html

//0x656f3d640000000000000000000000000000000000000000000000000000000000000060000000000000000000000000000000000000000000000000000000000000014000000000000000000000000000000000000000000000000000000000000002200000000000000000000000000000000000000000000000000000000000000006000000000000000000000000000000000000000000000000000000000000000b0000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000001e0000000000000000000000000000000000000000000000000000000000000002000000000000000000000000000000000000000000000000000000000000000400000000000000000000000000000000000000000000000000000000000000150000000000000000000000000000000000000000000000000000000000000006000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000600000000000000000000000000000000000000000000000000000000000000c0000000000000000000000000000000000000000000000000000000000000014000000000000000000000000000000000000000000000000000000000000001a0000000000000000000000000000000000000000000000000000000000000034000000000000000000000000000000000000000000000000000000000000003c000000000000000000000000000000000000000000000000000000000000004200000000000000000000000000000000000000000000000000000000000000060000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000004d658c5317c4b4f8f1c6d000000000000000000000000ff498bbcbf40d0f30f178f553e8fa36153baf30b0000000000000000000000000000000000000000000000000000000000000180000000000000000000000000ff498bbcbf40d0f30f178f553e8fa36153baf30b00000000000000000000000000000000000000000000000000000000000000a000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000a4e343fe12000000000000000000000000a47c8bf37f92abed4a126bda807a7b7498661acd00000000000000000000000099d8a9c45b2eca8864373a26d1459e3dff1e17f3000000000000000000000000fb77650f0aa774220fbffee4677b169b06330878000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004d658c5317c4b4f8f1c6d000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000060000000000000000000000000000000000000000000050f9a9d2ec84eba51c164000000000000000000000000fb77650f0aa774220fbffee4677b169b0633087800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000040000000000000000000000000000000000000000000012623cc469bec120b69bd000000000000000000000000fb77650f0aa774220fbffee4677b169b063308780000000000000000000000000000000000000000000000000000000000000080000000000000000000000000a47c8bf37f92abed4a126bda807a7b7498661acd000000000000000000000000fb77650f0aa774220fbffee4677b169b063308780000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012623cc469bec120b69bd

//Function: cook(uint8[] actions, uint256[] values, bytes[] datas) ***
//
//MethodID: 0x656f3d64
//[0]:  0000000000000000000000000000000000000000000000000000000000000060
//[1]:  0000000000000000000000000000000000000000000000000000000000000140
//[2]:  0000000000000000000000000000000000000000000000000000000000000220
//[3]:  0000000000000000000000000000000000000000000000000000000000000006
//[4]:  000000000000000000000000000000000000000000000000000000000000000b
//[5]:  0000000000000000000000000000000000000000000000000000000000000004
//[6]:  000000000000000000000000000000000000000000000000000000000000001e
//[7]:  0000000000000000000000000000000000000000000000000000000000000002
//[8]:  0000000000000000000000000000000000000000000000000000000000000004
//[9]:  0000000000000000000000000000000000000000000000000000000000000015
//[10]: 0000000000000000000000000000000000000000000000000000000000000006
//[11]: 0000000000000000000000000000000000000000000000000000000000000000
//[12]: 0000000000000000000000000000000000000000000000000000000000000000
//[13]: 0000000000000000000000000000000000000000000000000000000000000000
//[14]: 0000000000000000000000000000000000000000000000000000000000000000
//[15]: 0000000000000000000000000000000000000000000000000000000000000000
//[16]: 0000000000000000000000000000000000000000000000000000000000000000

//[17]: 0000000000000000000000000000000000000000000000000000000000000006
//[18]: 00000000000000000000000000000000000000000000000000000000000000c0
//[19]: 0000000000000000000000000000000000000000000000000000000000000140
//[20]: 00000000000000000000000000000000000000000000000000000000000001a0
//[21]: 0000000000000000000000000000000000000000000000000000000000000340
//[22]: 00000000000000000000000000000000000000000000000000000000000003c0
//[23]: 0000000000000000000000000000000000000000000000000000000000000420
//[24]: 0000000000000000000000000000000000000000000000000000000000000060
//[25]: 0000000000000000000000000000000000000000000000000000000000000001
//[26]: 0000000000000000000000000000000000000000000000000000000000000000
//[27]: 0000000000000000000000000000000000000000000000000000000000000000
//[28]: 0000000000000000000000000000000000000000000000000000000000000040
//[29]: 00000000000000000000000000000000000000000004d658c5317c4b4f8f1c6d
//[30]: 000000000000000000000000ff498bbcbf40d0f30f178f553e8fa36153baf30b
//[31]: 0000000000000000000000000000000000000000000000000000000000000180
//[32]: 000000000000000000000000ff498bbcbf40d0f30f178f553e8fa36153baf30b
//[33]: 00000000000000000000000000000000000000000000000000000000000000a0
//[34]: 0000000000000000000000000000000000000000000000000000000000000000
//[35]: 0000000000000000000000000000000000000000000000000000000000000000
//[36]: 0000000000000000000000000000000000000000000000000000000000000002
//[37]: 00000000000000000000000000000000000000000000000000000000000000a4
//[38]: e343fe12000000000000000000000000a47c8bf37f92abed4a126bda807a7b74
//[39]: 98661acd00000000000000000000000099d8a9c45b2eca8864373a26d1459e3d
//[40]: ff1e17f3000000000000000000000000fb77650f0aa774220fbffee4677b169b
//[41]: 0633087800000000000000000000000000000000000000000000000000000000
//[42]: 0000000000000000000000000000000000000000000000000004d658c5317c4b
//[43]: 4f8f1c6d00000000000000000000000000000000000000000000000000000000
//[44]: 0000000000000000000000000000000000000000000000000000000000000060
//[45]: 000000000000000000000000000000000000000000050f9a9d2ec84eba51c164
//[46]: 000000000000000000000000fb77650f0aa774220fbffee4677b169b06330878
//[47]: 0000000000000000000000000000000000000000000000000000000000000000
//[48]: 0000000000000000000000000000000000000000000000000000000000000040
//[49]: 000000000000000000000000000000000000000000012623cc469bec120b69bd
//[50]: 000000000000000000000000fb77650f0aa774220fbffee4677b169b06330878
//[51]: 0000000000000000000000000000000000000000000000000000000000000080
//[52]: 000000000000000000000000a47c8bf37f92abed4a126bda807a7b7498661acd
//[53]: 000000000000000000000000fb77650f0aa774220fbffee4677b169b06330878
//[54]: 0000000000000000000000000000000000000000000000000000000000000000
//[55]: 000000000000000000000000000000000000000000012623cc469bec120b69bd


//0	actions	uint8[]	11
//4
//30
//2
//4
//21
//1	values	uint256[]	0
//0
//0
//0
//0
//0
//2	datas	bytes[]	0x000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
//0x00000000000000000000000000000000000000000004d658c5317c4b4f8f1c6d000000000000000000000000ff498bbcbf40d0f30f178f553e8fa36153baf30b
//0x000000000000000000000000ff498bbcbf40d0f30f178f553e8fa36153baf30b00000000000000000000000000000000000000000000000000000000000000a000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000a4e343fe12000000000000000000000000a47c8bf37f92abed4a126bda807a7b7498661acd00000000000000000000000099d8a9c45b2eca8864373a26d1459e3dff1e17f3000000000000000000000000fb77650f0aa774220fbffee4677b169b06330878000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004d658c5317c4b4f8f1c6d00000000000000000000000000000000000000000000000000000000
//0x000000000000000000000000000000000000000000050f9a9d2ec84eba51c164000000000000000000000000fb77650f0aa774220fbffee4677b169b063308780000000000000000000000000000000000000000000000000000000000000000
//0x000000000000000000000000000000000000000000012623cc469bec120b69bd000000000000000000000000fb77650f0aa774220fbffee4677b169b06330878
//0x000000000000000000000000a47c8bf37f92abed4a126bda807a7b7498661acd000000000000000000000000fb77650f0aa774220fbffee4677b169b063308780000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012623cc469bec120b69bd
