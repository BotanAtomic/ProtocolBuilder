package data.messages.game.context.roleplay.party
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class PartyNameUpdateMessage extends AbstractPartyMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6502;
       
      private var _isInitialized:Boolean = false;
      
      public var partyName:String = "";
      
      public function PartyNameUpdateMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6502;
      }
      
      public function initPartyNameUpdateMessage(param1:uint = 0, param2:String = "") : PartyNameUpdateMessage
      {
         super.initAbstractPartyMessage(param1);
         this.partyName = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.partyName = "";
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
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_PartyNameUpdateMessage(param1);
      }
      
      public function serializeAs_PartyNameUpdateMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeUTF(this.partyName);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_PartyNameUpdateMessage(param1);
      }
      
      public function deserializeAs_PartyNameUpdateMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._partyNameFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_PartyNameUpdateMessage(param1);
      }
      
      public function deserializeAsyncAs_PartyNameUpdateMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._partyNameFunc);
      }
      
      private function _partyNameFunc(param1:ICustomDataInput) : void
      {
         this.partyName = param1.readUTF();
      }
   }
}
