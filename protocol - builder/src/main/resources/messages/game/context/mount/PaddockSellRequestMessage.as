package com.ankamagames.dofus.network.messages.game.context.mount
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class PaddockSellRequestMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5953;
       
      private var _isInitialized:Boolean = false;
      
      public var price:Number = 0;
      
      public var forSale:Boolean = false;
      
      public function PaddockSellRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5953;
      }
      
      public function initPaddockSellRequestMessage(param1:Number = 0, param2:Boolean = false) : PaddockSellRequestMessage
      {
         this.price = param1;
         this.forSale = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.price = 0;
         this.forSale = false;
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
         this.serializeAs_PaddockSellRequestMessage(param1);
      }
      
      public function serializeAs_PaddockSellRequestMessage(param1:ICustomDataOutput) : void
      {
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
         param1.writeBoolean(this.forSale);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_PaddockSellRequestMessage(param1);
      }
      
      public function deserializeAs_PaddockSellRequestMessage(param1:ICustomDataInput) : void
      {
         this._priceFunc(param1);
         this._forSaleFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_PaddockSellRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_PaddockSellRequestMessage(param1:FuncTree) : void
      {
         param1.addChild(this._priceFunc);
         param1.addChild(this._forSaleFunc);
      }
      
      private function _priceFunc(param1:ICustomDataInput) : void
      {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.price + ") on element of PaddockSellRequestMessage.price.");
         }
      }
      
      private function _forSaleFunc(param1:ICustomDataInput) : void
      {
         this.forSale = param1.readBoolean();
      }
   }
}
