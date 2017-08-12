package data.messages.game.inventory.exchanges
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class ExchangePlayerRequestMessage extends ExchangeRequestMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5773;
       
      private var _isInitialized:Boolean = false;
      
      public var target:Number = 0;
      
      public function ExchangePlayerRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5773;
      }
      
      public function initExchangePlayerRequestMessage(param1:int = 0, param2:Number = 0) : ExchangePlayerRequestMessage
      {
         super.initExchangeRequestMessage(param1);
         this.target = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.target = 0;
         this._isInitialized = false;
      }
      
      override public function pack(param1:ICustomDataOutput) : void
      {
         var _loc2_:ByteArray = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
         {
            HASH_FUNCTION(_loc2_);
         }
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
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_ExchangePlayerRequestMessage(param1);
      }
      
      public function serializeAs_ExchangePlayerRequestMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_ExchangeRequestMessage(param1);
         if(this.target < 0 || this.target > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.target + ") on element target.");
         }
         param1.writeVarLong(this.target);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ExchangePlayerRequestMessage(param1);
      }
      
      public function deserializeAs_ExchangePlayerRequestMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._targetFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ExchangePlayerRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_ExchangePlayerRequestMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._targetFunc);
      }
      
      private function _targetFunc(param1:ICustomDataInput) : void
      {
         this.target = param1.readVarUhLong();
         if(this.target < 0 || this.target > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.target + ") on element of ExchangePlayerRequestMessage.target.");
         }
      }
   }
}
