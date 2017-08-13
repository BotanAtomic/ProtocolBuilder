package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.quest.GameRolePlayNpcQuestFlag;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapNpcsQuestStatusUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5642;
    private boolean _isInitialized = false;
    private int mapId = 0;
    private Vector<int> npcsIdsWithQuest;
    private Vector<GameRolePlayNpcQuestFlag> questFlags;
    private Vector<int> npcsIdsWithoutQuest;
    private FuncTree _npcsIdsWithQuesttree;
    private FuncTree _questFlagstree;
    private FuncTree _npcsIdsWithoutQuesttree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5642;
    }

    public MapNpcsQuestStatusUpdateMessage initMapNpcsQuestStatusUpdateMessage(int param1,Vector<int>  param2,Vector<GameRolePlayNpcQuestFlag>  param3,Vector<int>  param4) {
         this.mapId = param1;
         this.npcsIdsWithQuest = param2;
         this.questFlags = param3;
         this.npcsIdsWithoutQuest = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.mapId = 0;
         this.npcsIdsWithQuest = new Vector.<int>();
         this.questFlags = new Vector.<GameRolePlayNpcQuestFlag>();
         this.npcsIdsWithoutQuest = new Vector.<int>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MapNpcsQuestStatusUpdateMessage(param1);
    }

    public void serializeAs_MapNpcsQuestStatusUpdateMessage(ICustomDataOutput param1) {
         param1.writeInt(this.mapId);
         param1.writeShort(this.npcsIdsWithQuest.length);
         int _loc2_ = 0;
         while(_loc2_ < this.npcsIdsWithQuest.length)
         {
            param1.writeInt(this.npcsIdsWithQuest[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.questFlags.length);
         int _loc3_ = 0;
         while(_loc3_ < this.questFlags.length)
         {
            (this.questFlags[_loc3_] as GameRolePlayNpcQuestFlag).serializeAs_GameRolePlayNpcQuestFlag(param1);
            _loc3_++;
         }
         param1.writeShort(this.npcsIdsWithoutQuest.length);
         int _loc4_ = 0;
         while(_loc4_ < this.npcsIdsWithoutQuest.length)
         {
            param1.writeInt(this.npcsIdsWithoutQuest[_loc4_]);
            _loc4_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapNpcsQuestStatusUpdateMessage(param1);
    }

    public void deserializeAs_MapNpcsQuestStatusUpdateMessage(ICustomDataInput param1) {
         * _loc8_ = 0;
         GameRolePlayNpcQuestFlag _loc9_ = null;
         * _loc10_ = 0;
         this._mapIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc8_ = param1.readInt();
            this.npcsIdsWithQuest.push(_loc8_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc9_ = new GameRolePlayNpcQuestFlag();
            _loc9_.deserialize(param1);
            this.questFlags.push(_loc9_);
            _loc5_++;
         }
         int _loc6_ = param1.readUnsignedShort();
         int _loc7_ = 0;
         while(_loc7_ < _loc6_)
         {
            _loc10_ = param1.readInt();
            this.npcsIdsWithoutQuest.push(_loc10_);
            _loc7_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapNpcsQuestStatusUpdateMessage(param1);
    }

    public void deserializeAsyncAs_MapNpcsQuestStatusUpdateMessage(FuncTree param1) {
         param1.addChild(this._mapIdFunc);
         this._npcsIdsWithQuesttree = param1.addChild(this._npcsIdsWithQuesttreeFunc);
         this._questFlagstree = param1.addChild(this._questFlagstreeFunc);
         this._npcsIdsWithoutQuesttree = param1.addChild(this._npcsIdsWithoutQuesttreeFunc);
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _npcsIdsWithQuesttreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._npcsIdsWithQuesttree.addChild(this._npcsIdsWithQuestFunc);
            _loc3_++;
         }
    }

    private void _npcsIdsWithQuestFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         this.npcsIdsWithQuest.push(_loc2_);
    }

    private void _questFlagstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._questFlagstree.addChild(this._questFlagsFunc);
            _loc3_++;
         }
    }

    private void _questFlagsFunc(ICustomDataInput param1) {
         GameRolePlayNpcQuestFlag _loc2_ = new GameRolePlayNpcQuestFlag();
         _loc2_.deserialize(param1);
         this.questFlags.push(_loc2_);
    }

    private void _npcsIdsWithoutQuesttreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._npcsIdsWithoutQuesttree.addChild(this._npcsIdsWithoutQuestFunc);
            _loc3_++;
         }
    }

    private void _npcsIdsWithoutQuestFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         this.npcsIdsWithoutQuest.push(_loc2_);
    }

}