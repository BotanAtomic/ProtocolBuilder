package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class NpcDialogQuestionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5617;
    private boolean _isInitialized = false;
    private int messageId = 0;
    private String[] dialogParams;
    private int[] visibleReplies;
    private FuncTree _dialogParamstree;
    private FuncTree _visibleRepliestree;


    public void serialize(ICustomDataOutput param1) {
         if(this.messageId < 0)
         {
            throw new Exception("Forbidden value (" + this.messageId + ") on element messageId.");
         }
         param1.writeVarInt(this.messageId);
         param1.writeShort(this.dialogParams.length);
         int _loc2_ = 0;
         while(_loc2_ < this.dialogParams.length)
         {
            param1.writeUTF(this.dialogParams[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.visibleReplies.length);
         int _loc3_ = 0;
         while(_loc3_ < this.visibleReplies.length)
         {
            if(this.visibleReplies[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.visibleReplies[_loc3_] + ") on element 3 (starting at 1) of visibleReplies.");
            }
            param1.writeVarInt(this.visibleReplies[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         String _loc6_ = null;
         int _loc7_ = 0;
         this.messageId = param1.readVarUhInt();
         if(this.messageId < 0)
         {
            throw new Exception("Forbidden value (" + this.messageId + ") on element of NpcDialogQuestionMessage.messageId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUTF();
            this.dialogParams.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhInt();
            if(_loc7_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of visibleReplies.");
            }
            this.visibleReplies.push(_loc7_);
            _loc5_++;
         }
    }

}