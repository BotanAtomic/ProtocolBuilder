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
    private int[] npcsIdsWithQuest;
    private GameRolePlayNpcQuestFlag[] questFlags;
    private int[] npcsIdsWithoutQuest;
    private FuncTree _npcsIdsWithQuesttree;
    private FuncTree _questFlagstree;
    private FuncTree _npcsIdsWithoutQuesttree;


    public void serialize(ICustomDataOutput param1) {
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
         Object _loc8_ = 0;
         GameRolePlayNpcQuestFlag _loc9_ = null;
         Object _loc10_ = 0;
         this.mapId = param1.readInt();
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

}