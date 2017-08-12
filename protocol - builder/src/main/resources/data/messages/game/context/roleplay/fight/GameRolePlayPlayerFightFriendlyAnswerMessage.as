package data.messages.game.context.roleplay.fight
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class GameRolePlayPlayerFightFriendlyAnswerMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5732;
       
      private var _isInitialized:Boolean = false;
      
      public var fightId:int = 0;
      
      public var accept:Boolean = false;
      
      public function GameRolePlayPlayerFightFriendlyAnswerMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5732;
      }
      
      public function initGameRolePlayPlayerFightFriendlyAnswerMessage(param1:int = 0, param2:Boolean = false) : GameRolePlayPlayerFightFriendlyAnswerMessage
      {
         this.fightId = param1;
         this.accept = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.fightId = 0;
         this.accept = false;
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
         this.serializeAs_GameRolePlayPlayerFightFriendlyAnswerMessage(param1);
      }
      
      public function serializeAs_GameRolePlayPlayerFightFriendlyAnswerMessage(param1:ICustomDataOutput) : void
      {
         param1.writeInt(this.fightId);
         param1.writeBoolean(this.accept);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_GameRolePlayPlayerFightFriendlyAnswerMessage(param1);
      }
      
      public function deserializeAs_GameRolePlayPlayerFightFriendlyAnswerMessage(param1:ICustomDataInput) : void
      {
         this._fightIdFunc(param1);
         this._acceptFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_GameRolePlayPlayerFightFriendlyAnswerMessage(param1);
      }
      
      public function deserializeAsyncAs_GameRolePlayPlayerFightFriendlyAnswerMessage(param1:FuncTree) : void
      {
         param1.addChild(this._fightIdFunc);
         param1.addChild(this._acceptFunc);
      }
      
      private function _fightIdFunc(param1:ICustomDataInput) : void
      {
         this.fightId = param1.readInt();
      }
      
      private function _acceptFunc(param1:ICustomDataInput) : void
      {
         this.accept = param1.readBoolean();
      }
   }
}
