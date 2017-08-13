package com.ankamagames.dofus.network.messages.game.guild
{
   import com.ankamagames.dofus.network.messages.game.social.SocialNoticeSetRequestMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class GuildBulletinSetRequestMessage extends SocialNoticeSetRequestMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6694;
       
      private var _isInitialized:Boolean = false;
      
      [Transient]
      public var content:String = "";
      
      public var notifyMembers:Boolean = false;
      
      public function GuildBulletinSetRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6694;
      }
      
      public function initGuildBulletinSetRequestMessage(param1:String = "", param2:Boolean = false) : GuildBulletinSetRequestMessage
      {
         this.content = param1;
         this.notifyMembers = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.content = "";
         this.notifyMembers = false;
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
         this.serializeAs_GuildBulletinSetRequestMessage(param1);
      }
      
      public function serializeAs_GuildBulletinSetRequestMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_SocialNoticeSetRequestMessage(param1);
         param1.writeUTF(this.content);
         param1.writeBoolean(this.notifyMembers);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_GuildBulletinSetRequestMessage(param1);
      }
      
      public function deserializeAs_GuildBulletinSetRequestMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._contentFunc(param1);
         this._notifyMembersFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_GuildBulletinSetRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_GuildBulletinSetRequestMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._contentFunc);
         param1.addChild(this._notifyMembersFunc);
      }
      
      private function _contentFunc(param1:ICustomDataInput) : void
      {
         this.content = param1.readUTF();
      }
      
      private function _notifyMembersFunc(param1:ICustomDataInput) : void
      {
         this.notifyMembers = param1.readBoolean();
      }
   }
}
