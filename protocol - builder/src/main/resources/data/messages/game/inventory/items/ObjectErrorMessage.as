package data.messages.game.inventory.items
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class ObjectErrorMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 3004;
       
      private var _isInitialized:Boolean = false;
      
      public var reason:int = 0;
      
      public function ObjectErrorMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 3004;
      }
      
      public function initObjectErrorMessage(param1:int = 0) : ObjectErrorMessage
      {
         this.reason = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.reason = 0;
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
         this.serializeAs_ObjectErrorMessage(param1);
      }
      
      public function serializeAs_ObjectErrorMessage(param1:ICustomDataOutput) : void
      {
         param1.writeByte(this.reason);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ObjectErrorMessage(param1);
      }
      
      public function deserializeAs_ObjectErrorMessage(param1:ICustomDataInput) : void
      {
         this._reasonFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ObjectErrorMessage(param1);
      }
      
      public function deserializeAsyncAs_ObjectErrorMessage(param1:FuncTree) : void
      {
         param1.addChild(this._reasonFunc);
      }
      
      private function _reasonFunc(param1:ICustomDataInput) : void
      {
         this.reason = param1.readByte();
      }
   }
}
