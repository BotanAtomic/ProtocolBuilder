package data.messages.game.context.roleplay
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   import com.ankamagames.dofus.network.ProtocolTypeManager;
   
   [Trusted]
   public class GameRolePlayShowActorMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5632;
       
      private var _isInitialized:Boolean = false;
      
      public var informations:GameRolePlayActorInformations;
      
      private var _informationstree:FuncTree;
      
      public function GameRolePlayShowActorMessage()
      {
         this.informations = new GameRolePlayActorInformations();
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5632;
      }
      
      public function initGameRolePlayShowActorMessage(param1:GameRolePlayActorInformations = null) : GameRolePlayShowActorMessage
      {
         this.informations = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.informations = new GameRolePlayActorInformations();
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
         this.serializeAs_GameRolePlayShowActorMessage(param1);
      }
      
      public function serializeAs_GameRolePlayShowActorMessage(param1:ICustomDataOutput) : void
      {
         param1.writeShort(this.informations.getTypeId());
         this.informations.serialize(param1);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_GameRolePlayShowActorMessage(param1);
      }
      
      public function deserializeAs_GameRolePlayShowActorMessage(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         this.informations = ProtocolTypeManager.getInstance(GameRolePlayActorInformations,_loc2_);
         this.informations.deserialize(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_GameRolePlayShowActorMessage(param1);
      }
      
      public function deserializeAsyncAs_GameRolePlayShowActorMessage(param1:FuncTree) : void
      {
         this._informationstree = param1.addChild(this._informationstreeFunc);
      }
      
      private function _informationstreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         this.informations = ProtocolTypeManager.getInstance(GameRolePlayActorInformations,_loc2_);
         this.informations.deserializeAsync(this._informationstree);
      }
   }
}
