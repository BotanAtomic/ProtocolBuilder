package data.messages.game.basic
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class BasicAckMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6362;
       
      private var _isInitialized:Boolean = false;
      
      public var seq:uint = 0;
      
      public var lastPacketId:uint = 0;
      
      public function BasicAckMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6362;
      }
      
      public function initBasicAckMessage(param1:uint = 0, param2:uint = 0) : BasicAckMessage
      {
         this.seq = param1;
         this.lastPacketId = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.seq = 0;
         this.lastPacketId = 0;
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
         this.serializeAs_BasicAckMessage(param1);
      }
      
      public function serializeAs_BasicAckMessage(param1:ICustomDataOutput) : void
      {
         if(this.seq < 0)
         {
            throw new Error("Forbidden value (" + this.seq + ") on element seq.");
         }
         param1.writeVarInt(this.seq);
         if(this.lastPacketId < 0)
         {
            throw new Error("Forbidden value (" + this.lastPacketId + ") on element lastPacketId.");
         }
         param1.writeVarShort(this.lastPacketId);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_BasicAckMessage(param1);
      }
      
      public function deserializeAs_BasicAckMessage(param1:ICustomDataInput) : void
      {
         this._seqFunc(param1);
         this._lastPacketIdFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_BasicAckMessage(param1);
      }
      
      public function deserializeAsyncAs_BasicAckMessage(param1:FuncTree) : void
      {
         param1.addChild(this._seqFunc);
         param1.addChild(this._lastPacketIdFunc);
      }
      
      private function _seqFunc(param1:ICustomDataInput) : void
      {
         this.seq = param1.readVarUhInt();
         if(this.seq < 0)
         {
            throw new Error("Forbidden value (" + this.seq + ") on element of BasicAckMessage.seq.");
         }
      }
      
      private function _lastPacketIdFunc(param1:ICustomDataInput) : void
      {
         this.lastPacketId = param1.readVarUhShort();
         if(this.lastPacketId < 0)
         {
            throw new Error("Forbidden value (" + this.lastPacketId + ") on element of BasicAckMessage.lastPacketId.");
         }
      }
   }
}
