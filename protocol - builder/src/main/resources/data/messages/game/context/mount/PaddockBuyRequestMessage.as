package data.messages.game.context.mount
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class PaddockBuyRequestMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5951;
       
      private var _isInitialized:Boolean = false;
      
      public var proposedPrice:Number = 0;
      
      public function PaddockBuyRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5951;
      }
      
      public function initPaddockBuyRequestMessage(param1:Number = 0) : PaddockBuyRequestMessage
      {
         this.proposedPrice = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.proposedPrice = 0;
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
         this.serializeAs_PaddockBuyRequestMessage(param1);
      }
      
      public function serializeAs_PaddockBuyRequestMessage(param1:ICustomDataOutput) : void
      {
         if(this.proposedPrice < 0 || this.proposedPrice > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.proposedPrice + ") on element proposedPrice.");
         }
         param1.writeVarLong(this.proposedPrice);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_PaddockBuyRequestMessage(param1);
      }
      
      public function deserializeAs_PaddockBuyRequestMessage(param1:ICustomDataInput) : void
      {
         this._proposedPriceFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_PaddockBuyRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_PaddockBuyRequestMessage(param1:FuncTree) : void
      {
         param1.addChild(this._proposedPriceFunc);
      }
      
      private function _proposedPriceFunc(param1:ICustomDataInput) : void
      {
         this.proposedPrice = param1.readVarUhLong();
         if(this.proposedPrice < 0 || this.proposedPrice > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.proposedPrice + ") on element of PaddockBuyRequestMessage.proposedPrice.");
         }
      }
   }
}
