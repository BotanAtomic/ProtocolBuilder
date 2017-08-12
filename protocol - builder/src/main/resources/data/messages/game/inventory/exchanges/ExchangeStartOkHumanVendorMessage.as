package data.messages.game.inventory.exchanges
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSellInHumanVendorShop;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class ExchangeStartOkHumanVendorMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5767;
       
      private var _isInitialized:Boolean = false;
      
      public var sellerId:Number = 0;
      
      public var objectsInfos:Vector.<ObjectItemToSellInHumanVendorShop>;
      
      private var _objectsInfostree:FuncTree;
      
      public function ExchangeStartOkHumanVendorMessage()
      {
         this.objectsInfos = new Vector.<ObjectItemToSellInHumanVendorShop>();
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5767;
      }
      
      public function initExchangeStartOkHumanVendorMessage(param1:Number = 0, param2:Vector.<ObjectItemToSellInHumanVendorShop> = null) : ExchangeStartOkHumanVendorMessage
      {
         this.sellerId = param1;
         this.objectsInfos = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.sellerId = 0;
         this.objectsInfos = new Vector.<ObjectItemToSellInHumanVendorShop>();
         this._isInitialized = false;
      }
      
      override public function pack(param1:ICustomDataOutput) : void
      {
         var _loc2_:ByteArray = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
      }
      
      override public function unpack(param1:ICustomDataInput, param2:uint) : void
      {
         this.deserialize(param1);
      }
      
      override public function unpackAsync(param1:ICustomDataInput, param2:uint) : FuncTree
      {
         var _loc3_:FuncTree = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
      }
      
      public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_ExchangeStartOkHumanVendorMessage(param1);
      }
      
      public function serializeAs_ExchangeStartOkHumanVendorMessage(param1:ICustomDataOutput) : void
      {
         if(this.sellerId < -9.007199254740992E15 || this.sellerId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.sellerId + ") on element sellerId.");
         }
         param1.writeDouble(this.sellerId);
         param1.writeShort(this.objectsInfos.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.objectsInfos.length)
         {
            (this.objectsInfos[_loc2_] as ObjectItemToSellInHumanVendorShop).serializeAs_ObjectItemToSellInHumanVendorShop(param1);
            _loc2_++;
         }
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ExchangeStartOkHumanVendorMessage(param1);
      }
      
      public function deserializeAs_ExchangeStartOkHumanVendorMessage(param1:ICustomDataInput) : void
      {
         var _loc4_:ObjectItemToSellInHumanVendorShop = null;
         this._sellerIdFunc(param1);
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItemToSellInHumanVendorShop();
            _loc4_.deserialize(param1);
            this.objectsInfos.push(_loc4_);
            _loc3_++;
         }
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ExchangeStartOkHumanVendorMessage(param1);
      }
      
      public function deserializeAsyncAs_ExchangeStartOkHumanVendorMessage(param1:FuncTree) : void
      {
         param1.addChild(this._sellerIdFunc);
         this._objectsInfostree = param1.addChild(this._objectsInfostreeFunc);
      }
      
      private function _sellerIdFunc(param1:ICustomDataInput) : void
      {
         this.sellerId = param1.readDouble();
         if(this.sellerId < -9.007199254740992E15 || this.sellerId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.sellerId + ") on element of ExchangeStartOkHumanVendorMessage.sellerId.");
         }
      }
      
      private function _objectsInfostreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._objectsInfostree.addChild(this._objectsInfosFunc);
            _loc3_++;
         }
      }
      
      private function _objectsInfosFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:ObjectItemToSellInHumanVendorShop = new ObjectItemToSellInHumanVendorShop();
         _loc2_.deserialize(param1);
         this.objectsInfos.push(_loc2_);
      }
   }
}
