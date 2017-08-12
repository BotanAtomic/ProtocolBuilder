package data.messages.game.inventory.exchanges
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class ExchangeObjectMoveKamaMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5520;
       
      private var _isInitialized:Boolean = false;
      
      public var quantity:Number = 0;
      
      public function ExchangeObjectMoveKamaMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5520;
      }
      
      public function initExchangeObjectMoveKamaMessage(param1:Number = 0) : ExchangeObjectMoveKamaMessage
      {
         this.quantity = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.quantity = 0;
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
         this.serializeAs_ExchangeObjectMoveKamaMessage(param1);
      }
      
      public function serializeAs_ExchangeObjectMoveKamaMessage(param1:ICustomDataOutput) : void
      {
         if(this.quantity < -9.007199254740992E15 || this.quantity > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarLong(this.quantity);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ExchangeObjectMoveKamaMessage(param1);
      }
      
      public function deserializeAs_ExchangeObjectMoveKamaMessage(param1:ICustomDataInput) : void
      {
         this._quantityFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ExchangeObjectMoveKamaMessage(param1);
      }
      
      public function deserializeAsyncAs_ExchangeObjectMoveKamaMessage(param1:FuncTree) : void
      {
         param1.addChild(this._quantityFunc);
      }
      
      private function _quantityFunc(param1:ICustomDataInput) : void
      {
         this.quantity = param1.readVarLong();
         if(this.quantity < -9.007199254740992E15 || this.quantity > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.quantity + ") on element of ExchangeObjectMoveKamaMessage.quantity.");
         }
      }
   }
}
