package data.messages.handshake
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class ProtocolRequired extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 1;
       
      private var _isInitialized:Boolean = false;
      
      public var requiredVersion:uint = 0;
      
      public var currentVersion:uint = 0;
      
      public function ProtocolRequired()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 1;
      }
      
      public function initProtocolRequired(param1:uint = 0, param2:uint = 0) : ProtocolRequired
      {
         this.requiredVersion = param1;
         this.currentVersion = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.requiredVersion = 0;
         this.currentVersion = 0;
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
         this.serializeAs_ProtocolRequired(param1);
      }
      
      public function serializeAs_ProtocolRequired(param1:ICustomDataOutput) : void
      {
         if(this.requiredVersion < 0)
         {
            throw new Error("Forbidden value (" + this.requiredVersion + ") on element requiredVersion.");
         }
         param1.writeInt(this.requiredVersion);
         if(this.currentVersion < 0)
         {
            throw new Error("Forbidden value (" + this.currentVersion + ") on element currentVersion.");
         }
         param1.writeInt(this.currentVersion);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ProtocolRequired(param1);
      }
      
      public function deserializeAs_ProtocolRequired(param1:ICustomDataInput) : void
      {
         this._requiredVersionFunc(param1);
         this._currentVersionFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ProtocolRequired(param1);
      }
      
      public function deserializeAsyncAs_ProtocolRequired(param1:FuncTree) : void
      {
         param1.addChild(this._requiredVersionFunc);
         param1.addChild(this._currentVersionFunc);
      }
      
      private function _requiredVersionFunc(param1:ICustomDataInput) : void
      {
         this.requiredVersion = param1.readInt();
         if(this.requiredVersion < 0)
         {
            throw new Error("Forbidden value (" + this.requiredVersion + ") on element of ProtocolRequired.requiredVersion.");
         }
      }
      
      private function _currentVersionFunc(param1:ICustomDataInput) : void
      {
         this.currentVersion = param1.readInt();
         if(this.currentVersion < 0)
         {
            throw new Error("Forbidden value (" + this.currentVersion + ") on element of ProtocolRequired.currentVersion.");
         }
      }
   }
}
