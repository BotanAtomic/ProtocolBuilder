package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.ActorOrientation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameMapChangeOrientationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 946;
    private boolean _isInitialized = false;
    private ActorOrientation orientation;
    private FuncTree _orientationtree;


    public void serialize(ICustomDataOutput param1) {
         this.orientation.serializeAs_ActorOrientation(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.orientation = new ActorOrientation();
         this.orientation.deserialize(param1);
    }

}